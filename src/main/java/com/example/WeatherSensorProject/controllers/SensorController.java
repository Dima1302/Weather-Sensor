package com.example.WeatherSensorProject.controllers;

import com.example.WeatherSensorProject.models.Sensor;
import com.example.WeatherSensorProject.models.SensorDTO;
import com.example.WeatherSensorProject.services.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    @GetMapping("/sensors/{sensorName}")
    public ResponseEntity<String> checkSensor(@PathVariable String sensorName) {
        boolean isRegistered = sensorService.isSensorRegistered(sensorName);
        if (isRegistered) {
            return ResponseEntity.ok("Sensor is registered.");
        } else {
            return new ResponseEntity<>("Sensor not found.", HttpStatus.NOT_FOUND);
        }
    }
}

