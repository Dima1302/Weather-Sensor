package com.example.WeatherSensorProject.models;


import javax.persistence.*;

@Entity//Аннотация, указывающая, что класс Sensor является сущностью (entity) базы данных.
@Table(name = "sensor") //  Аннотация, указывающая имя таблицы в базе данных, связанной с сущностью Sensor.
public class Sensor {
    @Id // Аннотация, указывающая, что поле id является первичным ключом в таблице.
    @Column(name = "id") //Аннотация, указывающая имя столбца в таблице, соответствующего полю id.
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Аннотация, определяющая стратегию генерации значения для поля id.
    // В данном случае используется стратегия "IDENTITY",которая позволяет базе данных автоматически генерировать уникальные значения.
    private int id;

    @Column(name = "name")
    private String name ;


    public Sensor(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Sensor() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
