package Biblioteca;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Modelo{
   public static void guardarLibro(String titulo, String autor,String categoria,boolean disponibilidad){

      ArrayList<String>Libros=new ArrayList<>();
      Libros.addAll(cargarLibros());
      Libros.add(titulo + "%" + autor + "%" + categoria + "%" + disponibilidad);

      //Guardo el array de String con el metodo guardarArray del Gestor de Archivos
      GestorArchivos.guardarArray(Libros, "ArrayLibros.txt");
      try{
         PreparedStatement pSInsert= Conexion.getInstance().prepareStatement("INSERT INTO libros VALUES(?,?,?,?,?)");
         pSInsert.setString(1,null);
         pSInsert.setString(2, titulo);
         pSInsert.setString(3,autor);
         pSInsert.setString(4,categoria);
         pSInsert.setBoolean(5,disponibilidad);
         pSInsert.executeUpdate();

         Conexion.cerrarConexion();
         pSInsert.close();
      }catch (SQLException e){
         System.out.println("Error en guardar un libro");
         throw new RuntimeException(e);
      }
      for (int i=0;i<Libros.size();i++){
         System.out.println(Libros.get(i));
      }
   }
   public static void guardarSocio(String nombre, String apellido, int DNI){
      ArrayList<String>Socios=new ArrayList<>();
      Socios.addAll(cargarSocios());
      Socios.add(nombre+"%"+apellido+"%"+DNI);
      GestorArchivos.guardarArray(Socios,"ArraySocios.txt");
      try{
         PreparedStatement pSInsert= Conexion.getInstance().prepareStatement("INSERT INTO socios VALUES(?,?,?,?)");
         pSInsert.setString(1,null);
         pSInsert.setString(2, nombre);
         pSInsert.setString(3,apellido);
         pSInsert.setInt(4,DNI);

         pSInsert.executeUpdate();

         Conexion.cerrarConexion();
         pSInsert.close();
      }catch (SQLException e){
         System.out.println("Error en guardar un socio");
         throw new RuntimeException(e);
      }
   }

   public static void guardarPedido(LocalDate prestamo, LocalDate fecha_Devolver, Libro libroPedido, Socio socioPrestado){
      ArrayList<String>Pedidos=new ArrayList<>();

      Pedidos.add(prestamo+"%"+fecha_Devolver+"%"+libroPedido.toString("&")+"%"+socioPrestado.toString("&"));
      GestorArchivos.guardarArray(Pedidos,"ArrayPedidos.txt");
   }


   public static ArrayList<String> cargarSocios(){
      ArrayList<String> Socios=GestorArchivos.cargarArray("ArraySocios.txt");
     /* try{
         PreparedStatement pSSelect= Conexion.getInstance().prepareStatement("SELECT * FROM socios");
         ResultSet rs=pSSelect.executeQuery();

         while (rs.next()){
            System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
         }
         Conexion.cerrarConexion();
         pSSelect.close();
      }catch (SQLException e){
         System.out.println("Error al recuperar un socio");
         throw new RuntimeException(e);
      }*/

      return Socios;
   }
   public static ArrayList<String> cargarLibros(){
      ArrayList<String> LibrosCargados = GestorArchivos.cargarArray("ArrayLibros.txt");
      return LibrosCargados;
   }

   public static ArrayList<Libro> cargarArrayDeObjetoLibro(){
      ArrayList<Libro>objetoLibro=new ArrayList<>();
      String vector[];
      for (int i=0;i<cargarLibros().size();i++){
        vector =cargarLibros().get(i).split("%");
         String titulo = vector[0];
         String autor = vector[1];
         String categoria = vector[2];
         boolean disp = Boolean.parseBoolean(vector[3]);

         objetoLibro.add(new Libro(titulo,autor,categoria,disp));
      }

      return objetoLibro;
   }

   public static ArrayList<Socio> cargarArrayDeObjetoSocio(){
      ArrayList<Socio>Socios=new ArrayList<>();
      String vector[];
      for (int i=0;i<cargarSocios().size();i++){
         vector=cargarSocios().get(i).split("%");
         Socios.add(new Socio(vector[0],vector[1],Integer.parseInt(vector[2])));
      }

      return Socios;
   }
   public static ArrayList<Pedido> cargarArrayDeObjetoPedido(){
      ArrayList<Pedido>Pedidos=new ArrayList<>();

      return Pedidos;

   }
}