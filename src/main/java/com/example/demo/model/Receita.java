package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class Receita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    private List<String> ingredientes;

    private List<String> imagesUrls;

    private List<String> modoDepreparo;

    private String dica;

    private Tipo tipo;

    public Receita() {
    }

    public Receita(String nome, List<String> ingredientes, List<String> imageUrl, List<String> modoDepreparo, String dica, Tipo tipo) {
        this.nome = nome;
        this.ingredientes = ingredientes;
        this.imagesUrls = imageUrl;
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


    public List<String> getImagesUrls() {
        return imagesUrls;
    }

    public void setImagesUrls(List<String> imagesUrls) {
        this.imagesUrls = imagesUrls;
    }

    public List<String> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<String> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public List<String> getModoDepreparo() {
        return modoDepreparo;
    }

    public void setModoDepreparo(List<String> modoDepreparo) {
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

    @Override
    public String toString() {
        return "Receita{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", ingredientes=" + ingredientes +
                ", imagesUrls=" + imagesUrls +
                ", modoDepreparo=" + modoDepreparo +
                ", dica='" + dica + '\'' +
                ", tipo=" + tipo +
                '}';
    }
}
