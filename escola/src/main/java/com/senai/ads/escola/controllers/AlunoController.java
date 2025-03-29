package com.senai.ads.escola.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.senai.ads.escola.model.Aluno;
import com.senai.ads.escola.repository.AlunoRepository;

@Controller
public class AlunoController {

    @Autowired
    AlunoRepository repository;

    @GetMapping("/aluno/cadastro")
    public String cadastro() {
        return "cadastro";

    }

    @PostMapping("/aluno/cadastro")
    public String cadastroAluno(Aluno aluno) {
        repository.save(aluno);
        return "cadastro";
    }

    @GetMapping("/aluno/lista")
    public ModelAndView listaAluno() {
        ModelAndView mv = new ModelAndView("lista");
        List<Aluno> alunos = new ArrayList<>();
        alunos = repository.findAll();
        mv.addObject("alunos", alunos);
        return mv;
    }

}
