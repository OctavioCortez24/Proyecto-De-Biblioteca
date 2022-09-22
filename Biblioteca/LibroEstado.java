package Biblioteca;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LibroEstado {
    private String nombreLibroEstado;
    private int libroEstadoID;

    public LibroEstado(int libroEstadoID,String nombreLibroEstado){
        this.libroEstadoID=libroEstadoID;
        this.nombreLibroEstado=nombreLibroEstado;
    }

    public int getLibroEstadoID() {
        return libroEstadoID;
    }

    public void setLibroEstadoID(int libroEstadoID) {
        this.libroEstadoID = libroEstadoID;
    }

    public String getNombreEstadoLibro() {
        return nombreLibroEstado;
    }

    public void setNombreEstadoLibro(String nombreEstadoLibro) {
        this.nombreLibroEstado = nombreEstadoLibro;
    }


    public void anadirLibroEstado(){

        try {
            PreparedStatement psInsert=Conexion.getInstance().prepareStatement("INSERT INTO LibroEstados VALUES(?,?)");
            psInsert.setInt(1,libroEstadoID);
            psInsert.setString(2,nombreLibroEstado);
            psInsert.executeUpdate();

            psInsert.close();
        } catch (SQLException e) {
            System.out.println("Error en guardar un LibroEstado");
            throw new RuntimeException(e);
        }
    }
}
