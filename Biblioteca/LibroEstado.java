package Biblioteca;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

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

    public static class EstadoLibro {
       private LocalDate fechaInicio;
       private LocalDate fechaFin;
       private int libroEsatadoID;
       private int libroID;

       public EstadoLibro(LocalDate fI,LocalDate fF,int libroID,int libroEsatadoID){
          this.fechaInicio=fI;
          this.fechaFin=fF;
          this.libroEsatadoID=libroEsatadoID;
          this.libroID=libroID;
       }

       public LocalDate getFechaInicio() {
          return fechaInicio;
       }

       public void setFechaInicio(LocalDate fechaInicio) {
          this.fechaInicio = fechaInicio;
       }

       public LocalDate getFechaFin() {
          return fechaFin;
       }

       public void setFechaFin(LocalDate fechaFin) {
          this.fechaFin = fechaFin;
       }

       public int getLibroEsatadoID() {
          return libroEsatadoID;
       }

       public void setLibroEsatadoID(int libroEsatadoID) {
          this.libroEsatadoID = libroEsatadoID;
       }

       public int getLibroID() {
          return libroID;
       }

       public void setLibroID(int libroID) {
          this.libroID = libroID;
       }

       public void anadirEstadoLibro(){
          ArrayList<String> EstadoLibro = new ArrayList<>();
          EstadoLibro.addAll(GestorArchivos.cargarArray("ArrayEstadoLibro.txt"));
          EstadoLibro.add(fechaInicio + "%" + fechaFin + "%" + libroID + "%" + libroID);
          GestorArchivos.guardarArray(EstadoLibro, "ArrayEstadoLibro.txt");
          try {
             if (libroEsatadoID==1){
                //Actulizo la tabla de Estados Libros, Modifico la fecha en la cual se cambio de estado el libro
                PreparedStatement pSUpdate = Conexion.getInstance().prepareStatement("UPDATE EstadoLibros SET " +
                        "fechaFinEL='" + LocalDate.now() + "'WHERE libroID=" + libroID);
                pSUpdate.executeUpdate();
                pSUpdate.close();
             }
             PreparedStatement psInsertEL = Conexion.getInstance().prepareStatement("INSERT INTO EstadoLibros VALUES(?,?,?,?,?)");
             psInsertEL.setString(1, null);
             //Aqui inserto la feecha en la cual empezo el estado actual del libro
             psInsertEL.setString(2, fechaInicio.toString());
             //Aqui inserto una fecha que siempre va a ser null, debido a que es la fecha en la cual el libro cambia de estado
             psInsertEL.setNull(3, 3, fechaFin + "");
             //Aqui inserto la id del Libro
             psInsertEL.setInt(4, libroID);
             //Esta id me indica en que estado se ecuentra el libro, 1=Ocupado, 2=Disponibble, 3=Desactivado
             psInsertEL.setInt(5, libroEsatadoID);
             psInsertEL.executeUpdate();


             psInsertEL.close();
          } catch (SQLException e) {
             System.out.println("Error al guardar un EstadoLibro");
             throw new RuntimeException(e);
          }

       }

       @Override
       public String toString() {
          return fechaInicio+" "+fechaFin+" "+libroID+" "+libroEsatadoID;
       }
    }
}
