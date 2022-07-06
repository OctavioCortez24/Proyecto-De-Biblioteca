package Biblioteca;

import java.util.Date;

public class Libro {
    private String tituloDeLib;
    private boolean disponibilidad;
    private String nombreDelAutor;
    private String categoria;


    public Libro() {

    }

    public Libro(String nombre, String nombreDelAutor, String categoria, boolean disponibilidad) {
        this.tituloDeLib = nombre;
        this.nombreDelAutor = nombreDelAutor;
        this.categoria = categoria;
        this.disponibilidad = disponibilidad;
    }

    public String getNombreDeLib() {
        return tituloDeLib;
    }

    public void setNombreDeLib(String nombreDeLib) {
        this.tituloDeLib = nombreDeLib;
    }

    public boolean getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getNombreDelAutor() {
        return nombreDelAutor;
    }

    public void setNombreDelAutor(String nombreDelAutor) {
        this.nombreDelAutor = nombreDelAutor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Titulo: " + tituloDeLib;
    }

    public String toString(char ceparador) {
        return "Titulo: " + tituloDeLib + ceparador + " Autor: " + nombreDelAutor + ceparador + " Categoria: " + categoria + ceparador + " Disponibilidad: " + disponibilidad;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
