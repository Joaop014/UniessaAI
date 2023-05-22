package com.example.demo.controller;

import com.example.demo.model.Receita;
import com.example.demo.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/receitas.html")
public class ReceitasController {

    @Autowired
    private ReceitaRepository repository;
    @GetMapping("/{id}")
    public  String lista(@RequestParam("id") Long id, Model model){
        Receita receita = repository.findById(id).orElseThrow();
        model.addAttribute("receita", receita);
        return "receitas.html";
    }



}
