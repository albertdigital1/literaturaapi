package com.literaturaapi.models;

public class Libro {
    private int id;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public int getNumeroDescargas() {
        return numeroDescargas;
    }

    public void setNumeroDescargas(int numeroDescargas) {
        this.numeroDescargas = numeroDescargas;
    }

    private String titulo;
    private String autor;
    private String idioma;
    private int numeroDescargas;

    public Libro(int i, String tituloLibro, String autor, String idioma, int descargas) {
    }



    // Constructor, getters y setters
}
