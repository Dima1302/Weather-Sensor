package com.example.WeatherSensorProject.models;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SensorDTO {
    @NotBlank(message = "Sensor name cannot be blank")//Аннотация, указывающая,
    // что поле name не может быть пустым или состоять только из пробелов.
    @Size(min = 3, max = 30, message = "Sensor name must be between 3 and 30 characters")//Аннотация, указывающая,
    // что длина значения поля name должна быть от 3 до 30 символов.
    private String name;

    public SensorDTO(String name) {
        this.name = name;
    }
    public SensorDTO() {
        // Конструктор без параметров
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
