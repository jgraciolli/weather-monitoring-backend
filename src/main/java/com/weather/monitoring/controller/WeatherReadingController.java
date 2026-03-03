package com.weather.monitoring.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weather.monitoring.entity.Station;
import com.weather.monitoring.entity.WeatherReading;
import com.weather.monitoring.repository.StationRepository;
import com.weather.monitoring.repository.WeatherReadingRepository;

@RestController
@RequestMapping("/readings")
public class WeatherReadingController {

    private final WeatherReadingRepository weatherReadingRepository;
    private final StationRepository stationRepository;

    public WeatherReadingController(
        WeatherReadingRepository weatherReadingRepository,
        StationRepository stationRepository
    ) {
        this.weatherReadingRepository = weatherReadingRepository;
        this.stationRepository = stationRepository;
    }

    @PostMapping("/{stationId}")
    public WeatherReading createReading(
        @PathVariable Long stationId,
        @RequestBody WeatherReading reading
    ) {
        Station station = stationRepository.findById(stationId)
            .orElseThrow(() -> new RuntimeException(
                "Estação meteorológica não encontrada."
            ));
        
        reading.setStation(station);
        reading.setRecordedAt(LocalDateTime.now());

        return weatherReadingRepository.save(reading);
    }

    @GetMapping("/{stationId}")
    public List<WeatherReading> getReadingsByStation(@PathVariable Long stationId) {
        return weatherReadingRepository.findByStationId(stationId);
    }

}
