package com.weather.monitoring.repository;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.weather.monitoring.entity.WeatherReading;

public interface WeatherReadingRepository extends JpaRepository<WeatherReading, Long> {

    List<WeatherReading> findByStationId(Long stationId);
    
    List<WeatherReading> findByStationIdAndRecordedAtBetween(
        Long stationId,
        LocalDateTime start,
        LocalDateTime end
    );
}
