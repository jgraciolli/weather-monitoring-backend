package com.weather.monitoring.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Estações Meteorológicas")
                        .version("1.0")
                        .description(
                            "API REST criada para IACIT que visa o gerenciamento de estações meteorológicas e leituras de parâmetros atmosféricos."));
    }
}
