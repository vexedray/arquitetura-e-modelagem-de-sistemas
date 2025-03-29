package com.rayssa.locacoes.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.rayssa.locacoes.entities.Veiculo;
import com.rayssa.locacoes.service.VeiculoService;

import java.util.List;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

    @Autowired
    VeiculoService service;

    @PostMapping("/novo")
    public ResponseEntity<String> cadastro(@RequestBody Veiculo veiculo) {
        return service.cadastro(veiculo);
    }

    @GetMapping("/lista")
    public ResponseEntity<List<Veiculo>> listagem() {
        return service.lista();
    }
}
