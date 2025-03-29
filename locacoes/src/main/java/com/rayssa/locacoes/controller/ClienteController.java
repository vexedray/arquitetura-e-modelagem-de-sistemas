package com.rayssa.locacoes.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.rayssa.locacoes.entities.Cliente;
import com.rayssa.locacoes.service.ClienteService;
import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteService service;

    @PostMapping("/novo")
    public ResponseEntity<String> cadastro(@RequestBody Cliente cliente) {
        return service.cadastro(cliente);
    }

    @GetMapping("/lista")
    public ResponseEntity<List<Cliente>> listagem() {
        return service.lista();
    }
}
