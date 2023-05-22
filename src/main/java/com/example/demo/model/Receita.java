package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Receita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String atividade;
    private String imageUrl;

    private String modoDepreparo;

    private String dica;

    private Tipo tipo;

    public Receita() {
    }

    public Receita(String nome, String atividade, String imageUrl, String modoDepreparo, String dica, Tipo tipo) {
        this.nome = nome;
        this.atividade = atividade;
        this.imageUrl = imageUrl;
        this.modoDepreparo = modoDepreparo;
        this.dica = dica;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAtividade() {
        return atividade;
    }

    public void setAtividade(String atividade) {
        this.atividade = atividade;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getModoDepreparo() {
        return modoDepreparo;
    }

    public void setModoDepreparo(String modoDepreparo) {
        this.modoDepreparo = modoDepreparo;
    }

    public String getDica() {
        return dica;
    }

    public void setDica(String dica) {
        this.dica = dica;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
}
