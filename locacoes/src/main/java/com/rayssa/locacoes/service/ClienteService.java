package com.rayssa.locacoes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rayssa.locacoes.entities.Cliente;
import com.rayssa.locacoes.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository repository;

    public ResponseEntity<String> cadastro(Cliente cliente) {
        repository.save(cliente);
        return new ResponseEntity<>("Cliente cadastrado com sucesso", HttpStatus.OK);
    }

    public ResponseEntity<List<Cliente>> lista() {
        List<Cliente> clientes = repository.findAll();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }
}