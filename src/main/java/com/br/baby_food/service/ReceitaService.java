package com.br.baby_food.service;

import com.br.baby_food.model.Receita;
import com.br.baby_food.model.ReceitaForm;
import com.br.baby_food.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReceitaService {
    @Autowired
    private ReceitaRepository repository;

    public Receita transformarReceita(ReceitaForm form){
        System.out.println(form.getImagesUrls());
        System.out.println(form.getIngredientes());
        System.out.println(form.getModoDepreparo());
        Receita receita = new Receita();
        receita.setNome(form.getNome());
        receita.setIngredientes(separarParaLista(form.getIngredientes()));
        receita.setImagesUrls(separarParaLista(form.getImagesUrls()));
        receita.setModoDepreparo(separarParaLista(form.getModoDepreparo()));

        receita.setDica(form.getDica());
        receita.setTipo(form.getTipo());
        return receita;
    }

    public List<String> separarParaLista(String s){
        System.out.println(s);
        String[] split = s.split("--");
        List<String> linhas = new ArrayList<>();
        linhas.addAll(List.of(split));
        return linhas;
    }

    public void salvar(Receita receita){
        repository.save(receita);
    }

    public Receita findById(Long id){
        return repository.findById(id).orElseThrow();
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }

}
