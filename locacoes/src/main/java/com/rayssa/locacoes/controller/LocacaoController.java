package com.rayssa.locacoes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.rayssa.locacoes.entities.Locacao;
import com.rayssa.locacoes.service.LocacaoService;

import java.util.List;

@RestController
@RequestMapping("/locacao")
public class LocacaoController {

    @Autowired
    LocacaoService service;

    @PostMapping("/novo")
    public ResponseEntity<String> cadastro(@RequestBody Locacao locacao) {
        return service.cadastro(locacao);
    }

    @GetMapping("/lista")
    public ResponseEntity<List<Locacao>> listagem() {
        return service.lista();
    }
}
