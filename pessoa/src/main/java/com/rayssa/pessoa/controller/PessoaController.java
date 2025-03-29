package com.rayssa.pessoa.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rayssa.pessoa.entities.Pessoa;
import com.rayssa.pessoa.service.PessoaService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    PessoaService service;

    @GetMapping("/teste")
    public ResponseEntity<String> teste() {
        return new ResponseEntity<>("Resposta API", HttpStatus.OK);
    }

    @PostMapping("/novo")
    public ResponseEntity<String> cadastro(@RequestBody Pessoa pessoa) {
        // repository.save(pessoa);
        // return new ResponseEntity<>("Cadastrado com sucesso!", HttpStatus.OK);
        return service.cadastro(pessoa);
    }

    @GetMapping("/lista")
    public ResponseEntity<List<Pessoa>> listagem() {
        return service.lista();
    }

    // @GetMapping("/lista")
    // public ResponseEntity<List<Pessoa>> lista() {
    // List<Pessoa> pessoaListada = repository.findAll();
    // return new ResponseEntity<>(pessoaListada, HttpStatus.OK);
    // }

}
