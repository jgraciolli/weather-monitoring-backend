package com.weather.monitoring.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "stations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Station {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome da estação não pode estar em branco.")
    @Column(nullable = false)
    private String name;

    private String location;

    private Double latitude;

    private Double longitude;

    private String status;

}
