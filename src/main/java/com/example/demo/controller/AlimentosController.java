package com.example.demo.controller;

import com.example.demo.dtos.AlimentosDTO;
import com.example.demo.model.Receita;
import com.example.demo.model.Tipo;
import com.example.demo.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AlimentosController {
    @Autowired
    private ReceitaRepository repository;

    @GetMapping("/alimentos.html")
    public String lista(Model model){
        List<Receita> receitas = repository.findAll();
        model.addAttribute("receitas", receitas);
        return "alimentos.html";
    }


}
