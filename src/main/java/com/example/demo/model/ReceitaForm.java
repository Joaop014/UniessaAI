package com.example.demo.model;

public class ReceitaForm {

    private String nome;

    private String ingredientes;

    private String imagesUrls;

    private String modoDepreparo;

    private String dica;

    private Tipo tipo;

    public ReceitaForm(String nome, String ingredientes, String imagesUrls, String modoDepreparo, String dica, Tipo tipo) {
        this.nome = nome;
        this.ingredientes = ingredientes;
        this.imagesUrls = imagesUrls;
        this.modoDepreparo = modoDepreparo;
        this.dica = dica;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public String getImagesUrls() {
        return imagesUrls;
    }

    public String getModoDepreparo() {
        return modoDepreparo;
    }

    public String getDica() {
        return dica;
    }

    public Tipo getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "ReceitaForm{" +
                "nome='" + nome + '\'' +
                ", ingredientes='" + ingredientes + '\'' +
                ", imagesUrls='" + imagesUrls + '\'' +
                ", modoDepreparo='" + modoDepreparo + '\'' +
                ", dica='" + dica + '\'' +
                ", tipo=" + tipo +
                '}';
    }
}
