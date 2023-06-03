package com.example.WeatherSensorProject.services;

import com.example.WeatherSensorProject.models.Measurement;
import com.example.WeatherSensorProject.models.MeasurementDTO;
import com.example.WeatherSensorProject.models.Sensor;
import com.example.WeatherSensorProject.repositories.MeasurementRepository;
import com.example.WeatherSensorProject.repositories.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MeasurementService {
    private final MeasurementRepository measurementRepository;
    private final SensorRepository sensorRepository;

@Autowired
    public MeasurementService(MeasurementRepository measurementRepository, SensorRepository sensorRepository) {
        this.measurementRepository = measurementRepository;
        this.sensorRepository = sensorRepository;
    }
    @Transactional
    public Measurement addMeasurement(MeasurementDTO measurementDTO) {
        String sensorName = measurementDTO.getSensor();
        Optional<Sensor> sensorOptional = sensorRepository.findByName(sensorName);
        Sensor sensor = sensorOptional.orElseThrow(() -> new IllegalArgumentException("Sensor not found"));

        Measurement measurement = new Measurement();
        measurement.setValue(measurementDTO.getValue());
        measurement.setRaining(measurementDTO.getRaining());
        measurement.setSensor(sensor);
        measurement.setCreated_at(LocalDateTime.now());

        return measurementRepository.save(measurement);
    }

    public List<Measurement> getAllMeasurements() {
        return measurementRepository.findAll();
    }

    public long getRainyDaysCount() {
        return measurementRepository.countByRaining(true);
    }
}
