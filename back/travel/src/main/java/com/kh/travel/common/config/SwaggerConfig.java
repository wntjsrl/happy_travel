package com.kh.travel.common.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(apiInfo());
    } // openAPI

    private Info apiInfo() {
        return new Info()
                .title("Happy_Travel")
                .description("Hayyp_Travel Swagger UI")
                .version("2.0.2");
    } // apiInfo
} // class
