package com.weather.monitoring.controller;

import org.springframework.web.bind.annotation.*;

import com.weather.monitoring.repository.StationRepository;
import com.weather.monitoring.entity.Station;
import java.util.List;

@RestController
@RequestMapping("/stations")
public class StationController {

    private final StationRepository stationRepository;

    public StationController(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }
    
    @GetMapping
    public List<Station> getAllStations() {
        return stationRepository.findAll();
    }

    @PostMapping
    public Station createStation(@RequestBody Station station) {
        return stationRepository.save(station);
    }
}
