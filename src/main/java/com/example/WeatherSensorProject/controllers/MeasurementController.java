package com.example.WeatherSensorProject.controllers;

import com.example.WeatherSensorProject.models.Measurement;
import com.example.WeatherSensorProject.models.MeasurementDTO;
import com.example.WeatherSensorProject.services.MeasurementService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/measurements")
public class MeasurementController {
    private final MeasurementService measurementService;
@Autowired
    public MeasurementController(MeasurementService measurementService) {
        this.measurementService = measurementService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addMeasurement(@Valid @RequestBody MeasurementDTO measurementDTO) {
        try {
            Measurement measurement = measurementService.addMeasurement(measurementDTO);
            return ResponseEntity.ok().body(measurement);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/measurements")
    public ResponseEntity<List<Measurement>> getAllMeasurements() {
        List<Measurement> measurements = measurementService.getAllMeasurements();
        return ResponseEntity.ok().body(measurements);
    }

    @GetMapping("/rainyDaysCount")
    public ResponseEntity<Long> getRainyDaysCount() {
        long count = measurementService.getRainyDaysCount();
        return ResponseEntity.ok().body(count);
    }
}
