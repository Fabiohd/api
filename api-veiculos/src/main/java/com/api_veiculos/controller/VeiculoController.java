package com.api_veiculos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api_veiculos.model.Veiculo;
import com.api_veiculos.repository.VeiculoRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/veiculos")
@Tag(name = "Veículos API", description = "API para gerenciamento de veículos")
public class VeiculoController {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @GetMapping("/marcas")
    @Operation(summary = "Listar marcas", description = "Retorna uma lista com todas as marcas salvas no banco")
    public ResponseEntity<List<String>> getMarcas() {
        List<String> marcas = veiculoRepository.findAll()
                .stream()
                .map(Veiculo::getMarca)
                .distinct()
                .toList();
        return ResponseEntity.ok(marcas);
    }

    @GetMapping
    @Operation(summary = "Listar veículos por marca", description = "Retorna uma lista de veículos de uma marca específica")
    public ResponseEntity<List<Veiculo>> getVeiculosPorMarca(@RequestParam String marca) {
        return ResponseEntity.ok(veiculoRepository.findByMarca(marca));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar veículo", description = "Atualiza as informações de um veículo existente")
    public ResponseEntity<Void> atualizarVeiculo(@PathVariable Long id, @RequestBody Veiculo veiculo) {
        veiculoRepository.findById(id).ifPresent(v -> {
            v.setModelo(veiculo.getModelo());
            v.setObservacoes(veiculo.getObservacoes());
            veiculoRepository.save(v);
        });
        return ResponseEntity.ok().build();
    }
}