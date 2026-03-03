package com.weather.monitoring.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;
import com.weather.monitoring.entity.Station;
import com.weather.monitoring.entity.WeatherReading;
import com.weather.monitoring.repository.StationRepository;
import com.weather.monitoring.repository.WeatherReadingRepository;

@Service
public class WeatherReadingService {

    private final WeatherReadingRepository weatherReadingRepository;
    private final StationRepository stationRepository;

    public WeatherReadingService(
        WeatherReadingRepository weatherReadingRepository,
        StationRepository stationRepository
    ) {
        this.weatherReadingRepository = weatherReadingRepository;
        this.stationRepository = stationRepository;
    }

    public WeatherReading createReading(Long stationId, WeatherReading reading) {
        Station station = stationRepository.findById(stationId)
            .orElseThrow(() -> new RuntimeException(
                "Estação meteorológica não encontrada."
            ));
        
        reading.setStation(station);
        reading.setRecordedAt(LocalDateTime.now());
        
        return weatherReadingRepository.save(reading);
    }
    
    public List<WeatherReading> getReadingsByStation(Long stationId) {
        return weatherReadingRepository.findByStationId(stationId);
    }

    public List<WeatherReading> getReadingsByStationAndPeriod(
        Long stationId,
        LocalDateTime start,
        LocalDateTime end
    ){
        return weatherReadingRepository
            .findByStationIdAndRecordedAtBetween(stationId, start, end);
    }

}
