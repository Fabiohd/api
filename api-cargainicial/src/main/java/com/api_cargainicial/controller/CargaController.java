package com.api_cargainicial.controller;

import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api_cargainicial.model.Marca;
import com.api_cargainicial.service.FipeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;



@RestController
@RequestMapping("/api/v1/carga")
@Tag(name = "Carga API", description = "API para carregar marcas e enviar ao RabbitMQ")
public class CargaController {

    @Autowired
    private FipeService fipeService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping
    @Operation(summary = "Carregar marcas", description = "Obtém as marcas da API FIPE e as envia para a fila RabbitMQ")
    public ResponseEntity<Void> carregarMarcas() {
        List<Marca> marcas = fipeService.getMarcas();
        marcas.forEach(marca -> rabbitTemplate.convertAndSend("marcasQueue", marca, message -> {
            message.getMessageProperties().getHeaders().put("__TypeId__", "com.api_veiculos.model.Marca");
            return message;
        }));
        return ResponseEntity.ok().build();
    }

}
