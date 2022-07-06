package Biblioteca;

import java.util.Calendar;
import java.util.Date;

public class Pedido {
    private Date fecha_Prestamo;
    private Date fecha_Devolver;
    private Libro libroPedido;
    private Socio socioPrestado;

    public Pedido() {

    }

    public Pedido(Date prestamo, Date fecha_Devolver, Libro libroPedido, Socio socioPrestado) {
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

    public Date getFecha_Prestamo() {
        return fecha_Prestamo;
    }

    public void setFecha_Prestamo(Date fecha_Prestamo) {
        this.fecha_Prestamo = fecha_Prestamo;
    }

    public Date getFecha_Devolver() {
        return fecha_Devolver;
    }

    public void setFecha_Devolver(Date fecha_Devolver) {
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
        return "Fecha que fue prestado: " + this.fecha_Prestamo + "\n" +
                "Fecha para ser devuelto: " + fecha_Devolver + "\n" +
                "Libro pedido: " + libroPedido + "\n" +
                "Socio nombre: " + socioPrestado;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
