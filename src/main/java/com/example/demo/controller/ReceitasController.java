package com.example.demo.controller;

import com.example.demo.model.Receita;
import com.example.demo.model.ReceitaForm;
import com.example.demo.model.Tipo;
import com.example.demo.repository.ReceitaRepository;
import com.example.demo.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class ReceitasController {

    @Autowired
    private ReceitaService receitaService;

    @GetMapping("/receitas/{id}")
    public  String lista(@PathVariable("id") Long id, Model model){
        Receita receita = receitaService.findById(id);
        model.addAttribute("receita", receita);
        return "receitas";
    }

    @GetMapping("/receitas/cadastrar")
    public String cadastrar(Model model){
        Tipo[] tipos = Tipo.values();
        model.addAttribute("tipos", tipos);
        return "/receitas/cadastrar";
    }

    @PostMapping("/receitas/novo")
    public String novo(ReceitaForm form){
        System.out.println(form.toString());
        Receita receita = receitaService.transformarReceita(form);
        System.out.println(receita);
        receitaService.salvar(receita);
        return "/receitas/cadastrar";


    }



}
