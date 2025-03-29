package com.rayssa.pessoa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rayssa.aula02.entities.Pessoa;
import com.rayssa.aula02.repository.PessoaRepository;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository repository;

    public ResponseEntity<String> cadastro(Pessoa pessoa) {
        repository.save(pessoa);
        return new ResponseEntity<>("Cadastrado com Sucesso", HttpStatus.OK);
    }

    public ResponseEntity<List<Pessoa>> lista() {
        List<Pessoa> pessoaListada = repository.findAll();
        return new ResponseEntity<>(pessoaListada, HttpStatus.OK);
    }
}
