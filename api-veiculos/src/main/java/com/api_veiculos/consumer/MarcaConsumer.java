package com.api_veiculos.consumer;

import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api_veiculos.model.Marca;
import com.api_veiculos.service.VeiculoService;


@Component
public class MarcaConsumer {


    @Autowired
    private VeiculoService veiculoService;

    @RabbitListener(queues = "marcasQueue", containerFactory = "rabbitListenerContainerFactory")
    public void consumirMarca(Marca marca) {
        veiculoService.processarMarca(marca);
    }

}
