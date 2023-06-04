package com.example.WeatherSensorProject.services;

import com.example.WeatherSensorProject.models.Sensor;
import com.example.WeatherSensorProject.models.SensorDTO;
import com.example.WeatherSensorProject.repositories.SensorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class SensorService {

    private final SensorRepository sensorRepository;
    private ModelMapper modelMapper;

    @Autowired
    public SensorService(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
        this.modelMapper = new ModelMapper();
    }

    public Sensor registerSensor(SensorDTO sensorDTO) {
        if (sensorRepository.findByName(sensorDTO.getName()).isPresent()) {
            throw new IllegalArgumentException("Sensor with the given name already exists");
        }

        Sensor sensor = modelMapper.map(sensorDTO, Sensor.class);
        sensorRepository.save(sensor);

        return sensor;
    }

    public boolean isSensorRegistered(String sensorName) {
        return sensorRepository.existsByName(sensorName);
    }






}
