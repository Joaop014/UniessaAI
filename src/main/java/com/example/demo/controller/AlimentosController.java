package com.example.demo.controller;

import com.example.demo.model.Receita;
import com.example.demo.model.Tipo;
import com.example.demo.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller("/alimentos")
public class AlimentosController {
    @Autowired
    private ReceitaRepository repository;

    @GetMapping("/alimentos.html")
    public String lista(Model model){
        //List<Receita> receitas = repository.findAll();
        List<Receita> receitas = new ArrayList<>();
        Receita receita = new Receita("juliaaaaaaaaaaaaa", "atividade", "https://www.buenasdicas.com/wp-content/uploads/2020/01/comidas-tipicas-eua-macncheese.jpg", "modo de preparo", "dica", Tipo.LINHA1);
        Receita receita2 = new Receita("Linha2", "atividade", "https://www.buenasdicas.com/wp-content/uploads/2020/01/comidas-tipicas-eua-macncheese.jpg", "modo de preparo", "dica", Tipo.LINHA2);
        Receita receita3 = new Receita("Linha3", "atividade", "https://www.buenasdicas.com/wp-content/uploads/2020/01/comidas-tipicas-eua-macncheese.jpg", "modo de preparo", "dica", Tipo.LINHA3);
        receita2.setId(1L);receita3.setId(3L);receita.setId(2L);
        receitas.add(receita);receitas.add(receita);receitas.add(receita);receitas.add(receita);receitas.add(receita);
        receitas.add(receita2);receitas.add(receita2);receitas.add(receita2);receitas.add(receita2);receitas.add(receita2);
        receitas.add(receita3);receitas.add(receita3);receitas.add(receita3);receitas.add(receita3);receitas.add(receita3);
        model.addAttribute("receitas", receitas);
        return "alimentos.html";
    }


}
