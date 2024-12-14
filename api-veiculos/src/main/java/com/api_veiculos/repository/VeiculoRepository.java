package com.api_veiculos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api_veiculos.model.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
    List<Veiculo> findByMarca(String marca);
}