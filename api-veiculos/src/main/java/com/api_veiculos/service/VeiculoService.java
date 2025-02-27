package com.api_veiculos.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.api_veiculos.model.Marca;
import com.api_veiculos.model.Veiculo;
import com.api_veiculos.repository.VeiculoRepository;

@Service
public class VeiculoService {


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private VeiculoRepository veiculoRepository;

    public void processarMarca(Marca marca) {
        String url = "https://parallelum.com.br/fipe/api/v1/carros/marcas/" + marca.getCodigo() + "/modelos";
        try {
            ResponseEntity<Map<String, List<Veiculo>>> response = restTemplate.exchange(
                    url, HttpMethod.GET, null, new ParameterizedTypeReference<>() {});

            List<Veiculo> modelos = response.getBody().get("modelos");
            modelos.forEach(v -> v.setMarca(marca.getNome()));

            veiculoRepository.saveAll(modelos);
        } catch (Exception e) {
        }
    }
}