package Biblioteca;

import javax.swing .*;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.ArrayList;


public class Modelo2 {


    static private ArrayList<Pedido> Pedidos = new ArrayList<>();

    public static ArrayList<Pedido> getPedidos() {
        return Pedidos;
    }

    static private ArrayList<Libro> Libros = new ArrayList<>();

    public static ArrayList<Libro> getLibros() {
        return Libros;
    }

    static private ArrayList<Socio> Socios = new ArrayList<>();

    public static ArrayList<Socio> getSocios() {
        return Socios;
    }

    public static void GuardarPedidos() {
        /*Debo copiar los datos de mis arrays de pedido porque el metodo de gestor de archivos, guardar ayrray,
        solamente permite array de tipo String.
         */
        //Copio los datos del Array de Pedidos a un array de String
        ArrayList<String> PedidosString = new ArrayList<>();
        for (int i = 0; i < Pedidos.size(); i++) {
            PedidosString.add(Pedidos.get(i).toString("&"));
        }

        //Guardo el array de String con el metodo guardarArray del Gestor de Archivos
        GestorArchivos.guardarArray(PedidosString, "ArrayPedidos.txt");
    }

    public static void GuardarSocios() {
        /*Debo copiar los datos de mis arrays de socio porque el metodo de gestor de archivos, guardar ayrray,
        solamente permite array de tipo String.
         */

        //Copio los datos del Array de Socios a un array de String
        ArrayList<String> SociosString = new ArrayList<>();
        for (int i = 0; i < Socios.size(); i++) {
            SociosString.add(Socios.get(i).toString("%"));
        }

        //Guardo el array de String
        GestorArchivos.guardarArray(SociosString, "ArraySocios.txt");
    }

    public static void GuardarLibros() {
        /*Debo copiar los datos de mis arrays de libro porque el metodo de gestor de archivos, guardar ayrray,
        solamente permite array de tipo String.
         */
        //Copio los datos del Array de Libros a un array de String
        ArrayList<String> LibrosString = new ArrayList<>();
        for (int i = 0; i < Libros.size(); i++) {
            LibrosString.add(Libros.get(i).toString("%"));
        }
        //Guardo el array
        GestorArchivos.guardarArray(LibrosString, "ArrayLibros.txt");
    }

   /* public static void CargarSocios() {
        Ahora recupero los arrays de String y los vuelvo a convertir en array de objetos.

        //Cargo el array Socio-------------
        ArrayList<String> SociosCargados = GestorArchivos.cargarArray("ArraySocios.txt");

        //Convierto el array de String a Objetos de tipo Socio
        if (SociosCargados != null) {
            for (int i = 0; i < SociosCargados.size(); i++) {
                Socio socio = Modelo2.recuperarSocio(SociosCargados.get(i));
                Socios.add(socio);
            }
        }
        //-----------------------------
    }*/

    public static void CargarLibros() {
        //Cargo el array de Libros
        ArrayList<String> LibrosCargados = GestorArchivos.cargarArray("ArrayLibros.txt");

        //Convierto el array de String a Objetos de tipo Libro
        for (int i = 0; i < LibrosCargados.size(); i++) {
            Libro libro = Modelo2.recuperarLibro(LibrosCargados.get(i));
            Libros.add(libro);
        }
        //-----------------------------
    }

  /*  public static void CargarPedidos() {

        //Cargo de array de Pedidos
        ArrayList<String> PedidosCargados = GestorArchivos.cargarArray("ArrayPedidos.txt");

        //Convierto de array de String a Objetos de tipo Pedido
        for (int i = 0; i < PedidosCargados.size(); i++) {
            Pedido pedido = Modelo2.recuperarPedido(PedidosCargados.get(i));
            Pedidos.add(pedido);
        }
        //-----------------------------
    }*/

    /*public static Socio recuperarSocio(String cadena) {

        String[] vector = cadena.split("%");
        String nombre = vector[0];
        String apellido = vector[1];
        String dniString = vector[2];

        int DNI = Integer.parseInt(dniString);
        return new Socio(nombre, apellido, DNI);
    }*/

    public static Libro recuperarLibro(String cadena) {

        String[] vector = cadena.split("%");
        int idLibro=Integer.parseInt(vector[0]);
        String nombre = vector[1];
        String autor = vector[2];
        String categoria = vector[3];
        String disponibilidad = vector[4];
        boolean disp = Boolean.parseBoolean(disponibilidad);
        return new Libro(idLibro,nombre, autor, categoria, disp,false);
    }

   /* public static Pedido recuperarPedido(String cadena) {
        String[] vector = cadena.split("&");
        String fechaPrestamo = vector[0];
        LocalDate prestamo = LocalDate.parse(fechaPrestamo);
        String fechaDevolver = vector[1];
        LocalDate devolver = LocalDate.parse(fechaDevolver);
        String libro = vector[2];
        Libro LibroPedido = recuperarLibro(libro);
        String socio = vector[3];
        Socio SocioP = recuperarSocio(socio);

        return new Pedido(prestamo, devolver, LibroPedido, SocioP);
    }*/


    public static void guardarSocio(Socio s) {
        boolean bandera = false;
        for (int i = 0; i < Socios.size(); i++) {
            if (s.equals(Socios.get(i))) {
                bandera = true;
            }
        }

        if (!bandera) {
            Socios.add(s);
        } else {
            System.out.println("El socio que ingreso ya se encuentra añadido");
        }

    }

    public static void anadirPedido(Pedido p) {
        Pedidos.add(p);
    }

    public static void anadirLibro(Libro l) {
        Libros.add(l);
    }

    public static void borrarLibro(int numeroLibro) {
        try {
            Libros.remove(Libros.get(numeroLibro));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("No existe un libro que tenga asignado ese numero");
        }

    }

    public static void borrarSocio(int socio) {
        try {
            Socios.remove(Socios.get(socio));
            System.out.println("Socio borrado con exito");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("No existe un socio que tenga asignado ese numero");
        }
    }


}
