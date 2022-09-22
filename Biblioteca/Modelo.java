package Biblioteca;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Modelo {
    public static void guardarLibro(int libroID, String titulo, String autor, String categoria, boolean disponibilidad) {

        ArrayList<String> Libros = new ArrayList<>();
        Libros.addAll(GestorArchivos.cargarArray("ArrayLibros.txt"));
        Libros.add(libroID + "%" + titulo + "%" + autor + "%" + categoria + "%" + disponibilidad);
        //Guardo el array de String con el metodo guardarArray del Gestor de Archivos
        GestorArchivos.guardarArray(Libros, "ArrayLibros.txt");
        try {
            PreparedStatement pSInsert = Conexion.getInstance().prepareStatement("INSERT INTO libros VALUES(?,?,?,?,?)");
            pSInsert.setString(1, null);
            pSInsert.setString(2, titulo);
            pSInsert.setString(3, autor);
            pSInsert.setString(4, categoria);
            pSInsert.setBoolean(5, disponibilidad);
            pSInsert.executeUpdate();

            pSInsert.close();

        } catch (SQLException e) {
            System.out.println("Error en guardar un libro");
            throw new RuntimeException(e);
        }
    }

    public static void guardarSocio(int socioID, String nombre, String apellido, int DNI) {
        //Para guardar en txt
        ArrayList<String> Socios = new ArrayList<>();
        Socios.addAll(GestorArchivos.cargarArray("ArraySocios.txt"));
        Socios.add(socioID + "%" + nombre + "%" + apellido + "%" + DNI);
        GestorArchivos.guardarArray(Socios, "ArraySocios.txt");
        //------
        try {
            PreparedStatement pSInsert = Conexion.getInstance().prepareStatement("INSERT INTO socios VALUES(?,?,?,?)");
            pSInsert.setString(1, null);
            pSInsert.setString(2, nombre);
            pSInsert.setString(3, apellido);
            pSInsert.setInt(4, DNI);
            pSInsert.executeUpdate();


            pSInsert.close();

        } catch (SQLException e) {
            System.out.println("Error en guardar un socio");
            throw new RuntimeException(e);
        }

    }

    public static void guardarPedido(LocalDate prestamo, LocalDate fecha_Devolver, int libroID, int socioID) {
        ArrayList<String> Pedidos = new ArrayList<>();
        Pedidos.addAll(GestorArchivos.cargarArray("ArrayPedidos.txt"));
        Pedidos.add(prestamo + "%" + fecha_Devolver + "%" + libroID + "%" + socioID);
        GestorArchivos.guardarArray(Pedidos, "ArrayPedidos.txt");

        try {
            PreparedStatement pSInsert = Conexion.getInstance().prepareStatement("INSERT INTO pedidos VALUES(?,?,?,?,?)");
            pSInsert.setString(1, null);
            pSInsert.setString(2, prestamo + "");
            pSInsert.setString(3, fecha_Devolver + "");
            pSInsert.setInt(4, libroID);
            pSInsert.setInt(5, socioID);
            pSInsert.executeUpdate();

            pSInsert.close();

            //Actulizo la tabla de Estados Libros, Modifico la fecha en la cual se cambio de estado el libro
            PreparedStatement pSUpdate = Conexion.getInstance().prepareStatement("UPDATE EstadoLibros SET " +
                    "fechaFinEL='" + LocalDate.now() + "'WHERE libroID=" + libroID);
            pSUpdate.executeUpdate();
            pSUpdate.close();

            PreparedStatement psInsertEL = Conexion.getInstance().prepareStatement("INSERT INTO EstadoLibros VALUES(?,?,?,?,?)");
            psInsertEL.setString(1, null);
            psInsertEL.setString(2, LocalDate.now().toString());
            psInsertEL.setNull(3, 3, null);
            psInsertEL.setInt(4, libroID);
            psInsertEL.setInt(5, 1);// El numero 1 es igual a Ocupado
            psInsertEL.executeUpdate();

            psInsertEL.close();
        } catch (SQLException e) {
            System.out.println("Error en guardar un pedido");
            throw new RuntimeException(e);
        }
    }

    public static void guardarEstadoLibro(LocalDate fInicio, LocalDate fFin, int libroEstadoID, int libroID) {
        ArrayList<String> EstadoLibro = new ArrayList<>();
        EstadoLibro.addAll(GestorArchivos.cargarArray("ArrayEstadoLibro.txt"));
        EstadoLibro.add(fInicio + "%" + fFin + "%" + libroID + "%" + libroEstadoID);
        GestorArchivos.guardarArray(EstadoLibro, "ArrayEstadoLibro.txt");
        try {
            PreparedStatement psInsertEL = Conexion.getInstance().prepareStatement("INSERT INTO EstadoLibros VALUES(?,?,?,?,?)");
            psInsertEL.setString(1, null);
            //Aqui inserto la feecha en la cual empezo el estado actual del libro
            psInsertEL.setString(2, fInicio.toString());
            //Aqui inserto una fecha que siempre va a ser null, debido a que es la fecha en la cual el libro cambia de estado
            psInsertEL.setNull(3, 3, fFin + "");
            //Aqui inserto la id del Libro
            psInsertEL.setInt(4, libroID);
            //Esta id me indica en que estado se ecuentra el libro, en este caso es 2, que significa Disponible
            psInsertEL.setInt(5, libroEstadoID);
            psInsertEL.executeUpdate();

            psInsertEL.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar un EstadoLibro");
            throw new RuntimeException(e);
        }
    }


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

    public static ArrayList<EstadoLibro> cargarArrayDeObjetoEstadoLibros() {
        ArrayList<String> estadoLibrosString = GestorArchivos.cargarArray("ArrayEstadoLibro.txt");

        ArrayList<EstadoLibro> estadoLibros = new ArrayList<>();
        try {
            //Selecciona todos los campos de la tabla de EstadoLibros
            PreparedStatement pSSelect = Conexion.getInstance().prepareStatement("SELECT * FROM EstadoLibros");
            ResultSet rs = pSSelect.executeQuery();
            LocalDate fechaFin;
            while (rs.next()) {
                try {
                    fechaFin = LocalDate.parse(rs.getString(3));
                } catch (NullPointerException e) {
                    fechaFin = null;
                }
                estadoLibros.add(new EstadoLibro(LocalDate.parse(rs.getString(2)), fechaFin,
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