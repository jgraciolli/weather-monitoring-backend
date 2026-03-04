package com.weather.monitoring.controller;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.weather.monitoring.entity.WeatherReading;
import com.weather.monitoring.service.WeatherReadingService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/readings")
public class WeatherReadingController {    

    private final WeatherReadingService weatherReadingService;

    public WeatherReadingController(WeatherReadingService weatherReadingService) {
        this.weatherReadingService = weatherReadingService;  
    }        

    @GetMapping
    public List<WeatherReading> getReadingsByStation(
        @RequestParam(required = false) Long stationId,
        @RequestParam(required = false) LocalDateTime start,
        @RequestParam(required = false) LocalDateTime end
    ) {
        

        if (stationId != null) {

            if (start != null && end != null) {
                return weatherReadingService
                    .getReadingsByStationAndPeriod(stationId, start, end);
            }
                            
            return weatherReadingService.getReadingsByStation(stationId);
        }          
                    
        return weatherReadingService.getAllReadings();
    }

    @GetMapping("/{id}")
    public WeatherReading getReadingById(@PathVariable Long id) {
        return weatherReadingService.getReadingById(id);
    }

    @PostMapping("/{stationId}")
    public WeatherReading createReading(
        @PathVariable Long stationId,
        @RequestBody @Valid WeatherReading reading
    ) {
        return weatherReadingService.createReading(stationId, reading);
    }

    @PutMapping("/{readingId}")
    public WeatherReading updateReading(
        @PathVariable Long readingId, 
        @RequestBody @Valid WeatherReading updatedReading
    ) {

        return weatherReadingService.updateReading(readingId, updatedReading);
    }

    @DeleteMapping("/{readingId}")
    public void deleteReading(@PathVariable Long readingId) {
        weatherReadingService.deleteReading(readingId);
    }

}
