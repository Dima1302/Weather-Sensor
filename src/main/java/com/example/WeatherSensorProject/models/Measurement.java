package com.example.WeatherSensorProject.models;



import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity // Аннотация, указывающая, что класс Measurement является сущностью (entity) базы данных.
@Table(name = "measurements")//Аннотация, указывающая имя таблицы в базе данных, связанной с сущностью Measurement.
public class Measurement {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    public boolean isRaining() {
        return raining;
    }


    public void setRaining(boolean raining) {
        this.raining = raining;
    }
    // Поле, указывающее наличие осадков (дождя)
    @Column(name = "raining")
    private boolean raining;

    // Поле для значения измерения
    @Column(name = "value")
    private Double value;
    // Поле для хранения времени создания измерения
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Column(name = "created_at")
    private LocalDateTime created_at;

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
    // Связь "многие-к-одному" с сущностью Sensor
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sensor_id", nullable = false)
    private Sensor sensor;

    public Measurement() {
// Конструктор без параметров
    }
    // Геттеры и сеттеры для полей
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }
}
