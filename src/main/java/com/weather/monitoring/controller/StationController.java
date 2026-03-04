package com.weather.monitoring.controller;

import org.springframework.web.bind.annotation.*;
import com.weather.monitoring.service.StationService;
import jakarta.validation.Valid;
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

    @GetMapping("/{id}")
    public Station getStationById(@PathVariable Long id) {
        return stationService.getStationById(id);
    }

    @PostMapping
    public Station createStation(@RequestBody @Valid Station station) {
        return stationService.createStation(station);
    }

    @PutMapping("/{id}")
    public Station updateStation(
        @PathVariable Long id,
        @RequestBody @Valid Station station
    ){
        return stationService.updateStation(id, station);
    }

    @DeleteMapping("/{id}")
    public void deleteStation(@PathVariable Long id){
        stationService.deleteStation(id);
    }

}
