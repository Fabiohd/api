package com.api_cargainicial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.api_cargainicial.model.Marca;

@Service
public class FipeService {

    @Autowired
    RestTemplate restTemplate;

    public List<Marca> getMarcas() {
        String url = "https://parallelum.com.br/fipe/api/v1/carros/marcas";
        ResponseEntity<List<Marca>> response = restTemplate.exchange(
                url, HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
        return response.getBody();
    }
}