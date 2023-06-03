package com.example.WeatherSensorProject.models;


import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class MeasurementDTO {
    @NotNull(message = "Value cannot be null")
    @DecimalMin(value = "-100", message = "Value must be greater than or equal to -100")
    @DecimalMax(value = "100", message = "Value must be less than or equal to 100")
    private Double value;

    @NotNull(message = "Raining field cannot be null")
    private Boolean raining;

    public String getSensor() {
        return sensor;
    }

    public void setSensor(String sensor) {
        this.sensor = sensor;
    }

    @NotBlank(message = "Sensor name is required")
    private String sensor;



    public MeasurementDTO(Double value, Boolean raining, String sensor) {
        this.value = value;
        this.raining = raining;
        this.sensor = sensor;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Boolean getRaining() {
        return raining;
    }

    public void setRaining(Boolean raining) {
        this.raining = raining;
    }




}
