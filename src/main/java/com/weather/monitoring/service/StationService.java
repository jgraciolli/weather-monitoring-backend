package com.weather.monitoring.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.weather.monitoring.entity.Station;
import com.weather.monitoring.repository.StationRepository;

@Service
public class StationService {

    private final StationRepository stationRepository;

    public StationService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    public Station createStation(Station station) {
        return stationRepository.save(station);
    }

    public List<Station> getAllStations() {
        return stationRepository.findAll();
    }

    public Station getStationById(Long id) {
        return stationRepository.findById(id)
            .orElseThrow(() -> new RuntimeException(
                "Estação meteorológica não encontrada."
            ));
    }
}
