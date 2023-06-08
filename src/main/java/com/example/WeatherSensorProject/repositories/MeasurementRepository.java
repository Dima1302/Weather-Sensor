package com.example.WeatherSensorProject.repositories;

import com.example.WeatherSensorProject.models.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Аннотация, указывающая, что интерфейс MeasurementRepository является репозиторием,
// который обеспечивает доступ к данным (CRUD операции) для сущности Measurement.
public interface MeasurementRepository extends JpaRepository<Measurement,Integer> {
    long countByRaining(boolean isRaining);
}
