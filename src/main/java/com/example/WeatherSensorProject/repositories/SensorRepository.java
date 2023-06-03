package com.example.WeatherSensorProject.repositories;

import com.example.WeatherSensorProject.models.Sensor;
import com.example.WeatherSensorProject.models.SensorDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


/**
 * @author Neil Alishev
 */
@Repository
public interface SensorRepository extends JpaRepository<Sensor, Integer> {
    Optional<Sensor> findByName(String name);
    void save(SensorDTO sensorDTO);
    boolean existsByName(String name);


}
