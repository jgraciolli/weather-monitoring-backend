package com.weather.monitoring.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.weather.monitoring.entity.WeatherReading;
import com.weather.monitoring.service.WeatherReadingService;

@RestController
@RequestMapping("/readings")
public class WeatherReadingController {    

    private final WeatherReadingService weatherReadingService;

    public WeatherReadingController(WeatherReadingService weatherReadingService) {
        this.weatherReadingService = weatherReadingService;  
    }

    @PostMapping("/{stationId}")
    public WeatherReading createReading(
        @PathVariable Long stationId,
        @RequestBody WeatherReading reading
    ) {
        return weatherReadingService.createReading(stationId, reading);
    }

    @GetMapping("/{stationId}")
    public List<WeatherReading> getReadingsByStation(@PathVariable Long stationId) {
        return weatherReadingService.getReadingsByStation(stationId);
    }

}
