package com.weather.monitoring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.weather.monitoring.entity.Station;

public interface StationRepository extends JpaRepository<Station, Long> {

}
