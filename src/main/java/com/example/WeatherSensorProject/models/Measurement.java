package com.example.WeatherSensorProject.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "measurements")
public class Measurement {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public boolean isRaining() {// нужен ли?
        return raining;
    }
    public void getRaining(boolean raining){
        this.raining = raining;
    }

    public void setRaining(boolean raining) {
        this.raining = raining;
    }

    @Column(name = "is_raining")
    private boolean raining;


    @Column(name = "value")
    private double value;


    @Column(name = "created_at")
    private LocalDateTime created_at;

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sensor_id", nullable = false)
    private Sensor sensor;

    public Measurement() {

    }

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
