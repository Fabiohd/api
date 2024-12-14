package com.api_veiculos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;


@Configuration
public class OpenApiConfig {
	
	@Bean
	OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info()
					.title("API PARA CONSULTAR MARCAS E MODELOS DE VEICULOS")
					.version("v1")
					.description("API VEICULOS")
					.license(
						new License()
							.name("Apache 2.0")
							)
					);
	}

}
