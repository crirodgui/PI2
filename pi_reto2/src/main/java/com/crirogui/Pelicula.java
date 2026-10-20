package com.crirogui;

public class Pelicula {
    private String titulo;
    private int ano;
    private String pais;
    private String director;
    private String sinopsis;


    public Pelicula(String titulo, int ano, String pais, String director, String sinopsis) {
        this.titulo = titulo;
        this.ano = ano;
        this.pais = pais;
        this.director = director;
        this.sinopsis = sinopsis;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAno() {
        return ano;
    }

    public String getPais() {
        return pais;
    }

    public String getDirector() {
        return director;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "titulo='" + titulo + '\'' +
                ", ano=" + ano +
                ", pais='" + pais + '\'' +
                ", director='" + director + '\'' +
                ", sinopsis='" + sinopsis + '\'' +
                '}';
    }
}
