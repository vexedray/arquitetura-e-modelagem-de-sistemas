package com.rayssa.locacoes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rayssa.locacoes.entities.Veiculo;
import com.rayssa.locacoes.repository.VeiculoRepository;

@Service
public class VeiculoService {

    @Autowired
    VeiculoRepository repository;

    public ResponseEntity<String> cadastro(Veiculo veiculo) {
        repository.save(veiculo);
        return new ResponseEntity<>("Veículo cadastrado com sucesso", HttpStatus.OK);
    }

    public ResponseEntity<List<Veiculo>> lista() {
        List<Veiculo> veiculos = repository.findAll();
        return new ResponseEntity<>(veiculos, HttpStatus.OK);
    }
}
