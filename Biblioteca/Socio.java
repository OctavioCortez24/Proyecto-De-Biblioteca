package Biblioteca;


import java.util.ArrayList;
import java.util.Scanner;

public class Socio {

    private String nombre;
    private String apellido;
    private int DNI;
    private int socioID;

    public Socio() {
    }

    public Socio(int socioID,String nombre, String apellido, int DNI) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
        this.socioID=socioID;
    }

    public int getSocioID() {
        return socioID;
    }

    public void setSocioID(int socioID) {
        this.socioID = socioID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return DNI;
    }

    public void setDni(int ID) {
        this.DNI = DNI;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + " " + DNI;
    }

    public String toString(String ceparador) {
        return nombre + ceparador + apellido + ceparador + DNI;
    }

    @Override
    public boolean equals(Object obj) {
        Socio s = (Socio) obj;
        return nombre.equals(s.nombre) & apellido.equals(s.apellido) & DNI==s.DNI;
    }
    public void agregarSocio(){
        Modelo.guardarSocio(socioID,nombre,apellido,DNI);
    }
    public void darDeBaja(){

    }

}
