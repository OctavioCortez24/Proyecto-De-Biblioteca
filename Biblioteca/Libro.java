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
        String dispo = disponibilidad?"Disponible":"No Disponible";

        return "Titulo: " + tituloDeLib + "\n"
                + "Autor: " + nombreDelAutor + "\n"
                + "Categoria: " + categoria + "\n"
                + "Disponibilidad: " + dispo;
    }

    public String toString(String ceparador) {
        return tituloDeLib + ceparador + nombreDelAutor + ceparador + categoria + ceparador + disponibilidad;
    }

    @Override
    public boolean equals(Object obj) {
        Libro l= (Libro)obj;

        return tituloDeLib==l.tituloDeLib&nombreDelAutor==l.nombreDelAutor&categoria==l.categoria&disponibilidad==l.disponibilidad;
    }
}
