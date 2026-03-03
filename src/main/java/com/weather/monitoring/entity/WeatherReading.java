package com.weather.monitoring.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "weather_readings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WeatherReading {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double temperature;

    private Double humidity;

    private Double pressure;

    private Double windSpeed;

    private LocalDateTime recordedAt;

    @ManyToOne
    @JoinColumn(name = "station_id", nullable = false)
    private Station station;

}
