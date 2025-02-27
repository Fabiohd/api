package com.api_cargainicial.config;

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
					.title("API DE ENIVAR CARGA INICIAL PARA A FILA DO RABBITMQ")
					.version("v1")
					.description("API CARGA INICIAL")
					.license(
						new License()
							.name("Apache 2.0")
							)
					);
	}

}
