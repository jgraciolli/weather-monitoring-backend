package com.weather.monitoring.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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

    @NotNull
    private Double temperature;

    @NotNull
    private Double humidity;

    @NotNull
    private Double pressure;

    @NotNull
    @Positive
    private Double windSpeed;

    private LocalDateTime recordedAt;

    @ManyToOne
    @JoinColumn(name = "station_id", nullable = false)
    private Station station;

}
