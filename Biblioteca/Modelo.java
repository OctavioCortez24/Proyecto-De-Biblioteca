package Biblioteca;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Modelo {


    public static ArrayList<Libro> cargarArrayDeObjetoLibro() {
        ArrayList<String> LibrosCargados = GestorArchivos.cargarArray("ArrayLibros.txt");
        ArrayList<Libro> Libros = new ArrayList<>();
        String vector[];
        for (int i = 0; i < LibrosCargados.size(); i++) {
            vector = LibrosCargados.get(i).split("%");
            boolean disp = Boolean.parseBoolean(vector[4]);

            Libros.add(new Libro(Integer.parseInt(vector[0]), vector[1], vector[2], vector[3], disp));
        }
      /*  try {
            PreparedStatement pSSelect = Conexion.getInstance().prepareStatement("SELECT * FROM libros");
            ResultSet rs = pSSelect.executeQuery();
            while (rs.next()) {
                Libros.add(new Libro(rs.getString("tituloLibro"), rs.getString("autorLibro"), rs.getString("categoriaLibro"), rs.getBoolean("disponibilidadLibro")));
            }
            pSSelect.close();

        } catch (SQLException e) {
            System.out.println("Error al recuperar un libro");
            throw new RuntimeException(e);
        }*/
        return Libros;
    }

    public static ArrayList<Socio> cargarArrayDeObjetoSocio() {
        ArrayList<String> SociosTxt = GestorArchivos.cargarArray("ArraySocios.txt");
        ArrayList<Socio> Socios = new ArrayList<>();
        String vector[];
        for (int i = 0; i < SociosTxt.size(); i++) {
            vector = SociosTxt.get(i).split("%");
            Socios.add(new Socio(Integer.parseInt(vector[0]), vector[1], vector[2], Integer.parseInt(vector[3])));
        }
        /*try {
            PreparedStatement pSSelect = Conexion.getInstance().prepareStatement("SELECT * FROM socios");
            ResultSet rs = pSSelect.executeQuery();

            while (rs.next()) {
                Socios.add(new Socio(rs.getString("nombreSocio"), rs.getString("apellidoSocio"), rs.getInt("dniSocio")));
            }
            pSSelect.close();

        } catch (SQLException e) {
            System.out.println("Error al recuperar un socio");
            throw new RuntimeException(e);
        }*/

        return Socios;
    }

    public static ArrayList<Pedido> cargarArrayDeObjetoPedido() {
        ArrayList<String> SociosString = GestorArchivos.cargarArray("ArrayPedidos.txt");
        ArrayList<Pedido> Pedidos = new ArrayList<>();
        String vector[];
        for (int i = 0; i < SociosString.size(); i++) {
            vector = SociosString.get(i).split("%");
            Pedidos.add(new Pedido(LocalDate.parse(vector[0]), LocalDate.parse(vector[1]), Integer.parseInt(vector[2]), Integer.parseInt(vector[3])));
        }
      /* try {
            PreparedStatement pSSelect = Conexion.getInstance().prepareStatement("SELECT * FROM pedidos");
            ResultSet rs = pSSelect.executeQuery();
            while (rs.next()) {
              Pedidos.add(new Pedido(LocalDate.parse(rs.getString(2)), LocalDate.parse(rs.getString(3)), rs.getInt(4), rs.getInt(5)));
            }

            pSSelect.close();

        } catch (SQLException e) {
            System.out.println("Error al recuperar un libro");
            throw new RuntimeException(e);
        }*/

        return Pedidos;

    }

    public static ArrayList<LibroEstado.EstadoLibro> cargarArrayDeObjetoEstadoLibros() {
        ArrayList<String> estadoLibrosString = GestorArchivos.cargarArray("ArrayEstadoLibro.txt");
        LocalDate fechaFin;

        ArrayList<LibroEstado.EstadoLibro> estadoLibros = new ArrayList<>();
        for (int i=0;i<estadoLibrosString.size();i++){
            String cadena[]=estadoLibrosString.get(i).split("%");
            try {
                fechaFin = LocalDate.parse(cadena[1]);
            } catch (NullPointerException e) {
                fechaFin = null;
            }
            estadoLibros.add(new LibroEstado.EstadoLibro(LocalDate.parse(cadena[0]), fechaFin, Integer.parseInt(cadena[2]), Integer.parseInt(cadena[3])));
        }
        try {
            //Selecciona todos los campos de la tabla de EstadoLibros
            PreparedStatement pSSelect = Conexion.getInstance().prepareStatement("SELECT * FROM EstadoLibros");
            ResultSet rs = pSSelect.executeQuery();
            while (rs.next()) {
                try {
                    fechaFin = LocalDate.parse(rs.getString(3));
                } catch (NullPointerException e) {
                    fechaFin = null;
                }
                estadoLibros.add(new LibroEstado.EstadoLibro(LocalDate.parse(rs.getString(2)), fechaFin,
                        rs.getInt(4), rs.getInt(5)));
            }//Lleno el array de objetos EstadoLibro con los datos de la base de datos

            pSSelect.close();

        } catch (SQLException e) {
            System.out.println("Error al recuperar un EstadoLibro");
            throw new RuntimeException(e);
        }
        return estadoLibros;
    }
}