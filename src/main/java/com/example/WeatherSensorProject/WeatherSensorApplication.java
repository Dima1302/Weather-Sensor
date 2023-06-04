package com.example.WeatherSensorProject;

import com.example.WeatherSensorProject.models.MeasurementDTO;
import com.example.WeatherSensorProject.models.SensorDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@SpringBootApplication
public class WeatherSensorApplication {
	private static final String BASE_URL = "http://localhost:8080";
	private static final String REGISTER_SENSOR_URL = BASE_URL + "/sensors/register";
	private static final String ADD_MEASUREMENT_URL = BASE_URL + "/measurements/add";
	private static final String GET_MEASUREMENTS_URL = BASE_URL + "/measurements";


	public static void main(String[] args) {
		SpringApplication.run(WeatherSensorApplication.class, args);

		RestTemplate restTemplate = new RestTemplate();

		// Регистрация нового сенсора
		SensorDTO sensorDto = new SensorDTO("Sensor Name");
		ResponseEntity<SensorDTO> registrationResponse = restTemplate.postForEntity(
				REGISTER_SENSOR_URL, sensorDto, SensorDTO.class);
		String sensorId = registrationResponse.getBody().getName();

		// Отправка 1000 запросов со случайными температурами и "дождями"
		Random random = new Random();
		for (int i = 0; i < 1000; i++) {
			MeasurementDTO measurementDto = new MeasurementDTO(
					random.nextDouble() * 50,
					random.nextBoolean(),
					sensorId
			);
			restTemplate.postForObject(ADD_MEASUREMENT_URL, measurementDto, Void.class);
		}

		// Получение 1000 измерений с сервера
		ResponseEntity<MeasurementDTO[]> measurementsResponse = restTemplate.exchange(
				GET_MEASUREMENTS_URL, HttpMethod.GET, null, MeasurementDTO[].class);
		MeasurementDTO[] measurements = measurementsResponse.getBody();

		// Обработка полученных измерений
		if (measurements != null) {
			for (MeasurementDTO measurement : measurements) {
				System.out.println("Measurement: " + measurement);
			}
		} else {
			System.out.println("No measurements found.");
		}
	}


	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public ObjectMapper objectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		objectMapper.registerModule(new Hibernate5Module());
		objectMapper.registerModule(new JavaTimeModule());
		return objectMapper;
	}


	@Bean
	public JavaTimeModule javaTimeModule() {
		return new JavaTimeModule();
	}
}
