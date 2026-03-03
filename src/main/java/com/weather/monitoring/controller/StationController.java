package com.weather.monitoring.controller;

import org.springframework.web.bind.annotation.*;
import com.weather.monitoring.service.StationService;
import com.weather.monitoring.entity.Station;
import java.util.List;

@RestController
@RequestMapping("/stations")
public class StationController {

    private final StationService stationService;

    public StationController(StationService stationService) {
        this.stationService = stationService;
    }
    
    @GetMapping
    public List<Station> getAllStations() {
        return stationService.getAllStations();
    }

    @PostMapping
    public Station createStation(@RequestBody Station station) {
        return stationService.createStation(station);
    }
}
