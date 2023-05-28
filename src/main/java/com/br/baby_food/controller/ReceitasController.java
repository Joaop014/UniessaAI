package com.br.baby_food.controller;

import com.br.baby_food.model.Receita;
import com.br.baby_food.model.ReceitaForm;
import com.br.baby_food.model.Tipo;
import com.br.baby_food.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    @DeleteMapping("/receitas/deletar/{id}")
    public String apagar(@PathVariable Long id){
        if(receitaService.findById(id) != null){
            receitaService.deletar(id);
        }
        return "/receitas";
    }


}
