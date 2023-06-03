package com.example.WeatherSensorProject.controllers;

import com.example.WeatherSensorProject.models.Sensor;
import com.example.WeatherSensorProject.models.SensorDTO;
import com.example.WeatherSensorProject.services.SensorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sensors")
public class SensorController {
    private final SensorService sensorService;

    @Autowired
    public SensorController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @PostMapping("/registration")
    public ResponseEntity<?> registerSensor(@Valid @RequestBody SensorDTO sensorDTO) {
        try {
            Sensor sensor = sensorService.registerSensor(sensorDTO);
            return ResponseEntity.ok().body(sensor);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

