package com.example.demo.controller;

import com.example.demo.model.Receita;
import com.example.demo.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private ReceitaService receitaService;

    @GetMapping("/home")
    public String hello(Model model) {
        Receita receita = receitaService.HomeReceita();
        model.addAttribute("receita", receita);
        return "home";
    }

}
