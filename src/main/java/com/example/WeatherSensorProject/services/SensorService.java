package com.example.WeatherSensorProject.services;

import com.example.WeatherSensorProject.models.Sensor;
import com.example.WeatherSensorProject.models.SensorDTO;
import com.example.WeatherSensorProject.repositories.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = true)
public class SensorService {

    private final SensorRepository sensorRepository;

@Autowired
    public SensorService(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    public Sensor registerSensor(SensorDTO sensorDTO) {
        if (sensorRepository.findByName(sensorDTO.getName()).isPresent()) {
            throw new IllegalArgumentException("Sensor with the given name already exists");
        }

        Sensor sensor = new Sensor();
        sensor.setName(sensor.getName());
        sensorRepository.save(sensorDTO);
        return sensor;
    }

    public boolean isSensorRegistered(String sensorName) {
        return sensorRepository.existsByName(sensorName);
    }


//TODO: Исправить корректно ModelMapperом. Падает из за неверного использования dto как сущности.
    //TODO:Там,где используешь dto прописывай mapper.Нужно пересмотреть использование sensor,sensorDTO

}
