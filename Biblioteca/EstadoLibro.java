package Biblioteca;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class EstadoLibro {
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
      Modelo.guardarEstadoLibro(fechaInicio,fechaFin,libroEsatadoID,libroID);

   }

   @Override
   public String toString() {
      return fechaInicio+" "+fechaFin+" "+libroID+" "+libroEsatadoID;
   }
}
