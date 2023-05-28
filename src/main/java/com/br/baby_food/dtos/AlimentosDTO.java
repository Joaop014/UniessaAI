package com.br.baby_food.dtos;

import com.br.baby_food.model.Receita;
import com.br.baby_food.model.Tipo;

import java.util.ArrayList;
import java.util.List;

public class AlimentosDTO {

    private Long id;
    private Tipo tipo;
    private List<String> imagesUrls;
    private String nome;


    public AlimentosDTO(Long id, Tipo tipo, List<String> imagesUrls, String nome) {
        this.id = id;
        this.tipo = tipo;
        this.imagesUrls = imagesUrls;
        this.nome = nome;
    }

    public static List<AlimentosDTO> converter(List<Receita> receitas) {
       List<AlimentosDTO> alimentosDTOS = new ArrayList<>();
        for (Receita receita: receitas) {
            AlimentosDTO alimentosDTO = new AlimentosDTO(receita.getId(),
                                                         receita.getTipo(),
                                                         receita.getImagesUrls(),
                                                         receita.getNome());
            alimentosDTOS.add(alimentosDTO);
        }
        return alimentosDTOS;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public List<String> getImagesUrls() {
        return imagesUrls;
    }

    public void setImagesUrls(List<String> imagesUrls) {
        this.imagesUrls = imagesUrls;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
