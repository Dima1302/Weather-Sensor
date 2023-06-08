package com.example.WeatherSensorProject.models;


import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class MeasurementDTO {
    @NotNull(message = "Value cannot be null")  //Аннотация, указывающая, что поле value не может быть null.
    @DecimalMin(value = "-100", message = "Value must be greater than or equal to -100")//Аннотация,
    // указывающая, что значение поля value должно быть больше или равно -100.
    @DecimalMax(value = "100", message = "Value must be less than or equal to 100")//Аннотация,
    // указывающая, что значение поля value должно быть меньше или равно 100.
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
