package Biblioteca;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;


public class Pedido {
    private LocalDate fecha_Prestamo;
    private LocalDate fecha_Devolver;
    private int libroID;
    private int socioID;

    public Pedido() {}

    public Pedido(LocalDate prestamo, LocalDate fecha_Devolver, int libroID, int socioID) {
        this.fecha_Prestamo = prestamo;
        this.fecha_Devolver = fecha_Devolver;
        this.libroID = libroID;
        this.socioID = socioID;
    }
    //Getters and Setters


    public int getLibroID() {
        return libroID;
    }

    public void setLibroID(int libroID) {
        this.libroID = libroID;
    }

    public int getSocioID() {
        return socioID;
    }

    public void setSocioID(int socioID) {
        this.socioID = socioID;
    }

    public LocalDate getFecha_Prestamo() {
        return fecha_Prestamo;
    }

    public void setFecha_Prestamo(LocalDate fecha_Prestamo) {
        this.fecha_Prestamo = fecha_Prestamo;
    }

    public LocalDate getFecha_Devolver() {
        return fecha_Devolver;
    }

    public void setFecha_Devolver(LocalDate fecha_Devolver) {
        this.fecha_Devolver = fecha_Devolver;
    }

    //--------------------------------------------------------------------------------------------------
    public void devolverLibro() {
       //Terminar esto
    }

    public void anadirPedido() {

        Modelo.guardarPedido(fecha_Prestamo,fecha_Devolver,libroID,socioID);
    }

    ;

    @Override
    public String toString() {

        return "Fecha que fue prestado: " + fecha_Prestamo + "\n" +
                "Fecha para ser devuelto: " + fecha_Devolver + "\n" +
                "ID del Libro pedido: " + libroID + "\n" +
                "ID del Socio : " + socioID;
    }

    public String toString(String ceparador) {
        return fecha_Prestamo + ceparador + fecha_Devolver + ceparador + libroID + ceparador + socioID;
    }
}
