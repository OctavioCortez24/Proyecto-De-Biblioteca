package Biblioteca;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
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

        ArrayList<String> Pedidos = new ArrayList<>();
        Pedidos.addAll(GestorArchivos.cargarArray("ArrayPedidos.txt"));
        Pedidos.add(fecha_Prestamo + "%" + fecha_Devolver + "%" + libroID + "%" + socioID);
        GestorArchivos.guardarArray(Pedidos, "ArrayPedidos.txt");

        try {
            PreparedStatement pSInsert = Conexion.getInstance().prepareStatement("INSERT INTO pedidos VALUES(?,?,?,?,?)");
            pSInsert.setString(1, null);
            pSInsert.setString(2, fecha_Prestamo + "");
            pSInsert.setString(3, fecha_Devolver + "");
            pSInsert.setInt(4, libroID);
            pSInsert.setInt(5, socioID);
            pSInsert.executeUpdate();

            pSInsert.close();


        } catch (SQLException e) {
            System.out.println("Error en guardar un pedido");
            throw new RuntimeException(e);
        }
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
