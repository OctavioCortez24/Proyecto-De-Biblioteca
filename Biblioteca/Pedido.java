package Biblioteca;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;


public class Pedido {
    private LocalDate fecha_Prestamo;
    private LocalDate fecha_Devolver;
    private Libro libroPedido;
    private Socio socioPrestado;

    public Pedido() {

    }

    public Pedido(LocalDate prestamo, LocalDate fecha_Devolver, Libro libroPedido, Socio socioPrestado) {
        this.fecha_Prestamo = prestamo;
        this.fecha_Devolver = fecha_Devolver;
        this.libroPedido = libroPedido;
        this.socioPrestado = socioPrestado;
    }

    public Socio getSocioPrestado() {
        return socioPrestado;
    }

    public void setSocioPrestado(Socio socioPrestado) {
        this.socioPrestado = socioPrestado;
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

    public Libro getLibroPedido() {
        return libroPedido;
    }

    public void setLibroPedido(Libro libroPedido) {
        this.libroPedido = libroPedido;
    }

    @Override
    public String toString() {

        return "Fecha que fue prestado: " + fecha_Prestamo + "\n" +
                "Fecha para ser devuelto: " + fecha_Devolver + "\n" +
                "Libro pedido: " + libroPedido + "\n" +
                "Socio nombre: " + socioPrestado;
    }

    public String toString(String ceparador){
        return fecha_Prestamo+ceparador+fecha_Devolver+ceparador+libroPedido+ceparador+socioPrestado;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
