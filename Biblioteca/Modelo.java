package Biblioteca;

import java.time.LocalDate;
import java.util.ArrayList;

public class Modelo {
    public static void GuardarPedidos(ArrayList<Pedido> Pedidos) {
        /*Debo copiar los datos de mis arrays de pedido porque el metodo de gestor de archivos, guardar ayrray,
        solamente permite array de tipo String.
         */
        //Copio los datos del Array de Pedidos a un array de String
        ArrayList<String> PedidosString = new ArrayList<>();
        for (int i=0;i<Pedidos.size();i++){
            PedidosString.add(Pedidos.get(i).toString("&"));
        }

        //Guardo el array de String con el metodo guardarArray del Gestor de Archivos
        GestorArchivos.guardarArray(PedidosString, "ArrayPedidos.txt");
    }

    public static void GuardarSocios(ArrayList<Socio> Socios) {
        /*Debo copiar los datos de mis arrays de socio porque el metodo de gestor de archivos, guardar ayrray,
        solamente permite array de tipo String.
         */

        //Copio los datos del Array de Socios a un array de String
        ArrayList<String> SociosString = new ArrayList<>();
        for (int i=0;i<Socios.size();i++){
            SociosString.add(Socios.get(i).toString("%"));
        }

        //Guardo el array de String
        GestorArchivos.guardarArray(SociosString, "ArraySocios.txt");
    }

    public static void GuardarLibros(ArrayList<Libro> Libros) {
        /*Debo copiar los datos de mis arrays de libro porque el metodo de gestor de archivos, guardar ayrray,
        solamente permite array de tipo String.
         */
        //Copio los datos del Array de Libros a un array de String
        ArrayList<String> LibrosString = new ArrayList<>();
        for (int i=0;i<Libros.size();i++){
            LibrosString.add(Libros.get(i).toString("%"));
        }
        //Guardo el array
        GestorArchivos.guardarArray(LibrosString, "ArrayLibros.txt");
    }

    public static void CargarSocios(ArrayList<Socio> Socios) {
        /* Ahora recupero los arrays de String y los vuelvo a convertir en array de objetos.
         */
        //Cargo el array Socio-------------
        ArrayList<String> SociosCargados = GestorArchivos.cargarArray("ArraySocios.txt");
        if (SociosCargados!=null){
            for (int i = 0; i < SociosCargados.size(); i++) {

                Socio socio = Modelo.recuperarSocio(SociosCargados.get(i));
                Socios.add(socio);
            }
        }
        //-----------------------------
    }
    public static void  CargarLibros(ArrayList<Libro> Libros){
        //Cargo el array de Libros
        ArrayList<String> LibrosCargados = GestorArchivos.cargarArray("ArrayLibros.txt");
        for (int i = 0; i < LibrosCargados.size(); i++) {
            Libro libro = Modelo.recuperarLibro(LibrosCargados.get(i));
            Libros.add(libro);
        }
        //-----------------------------
    }
    public static void CargarPedidos(ArrayList<Pedido>Pedidos){

        //Cargo de array de Pedidos
        ArrayList<String> PedidosCargados = GestorArchivos.cargarArray("ArrayPedidos.txt");
        for (int i = 0; i < PedidosCargados.size(); i++) {
            Pedido pedido = Modelo.recuperarPedido(PedidosCargados.get(i));
            Pedidos.add(pedido);
        }
        //-----------------------------
    }

    public static Socio recuperarSocio(String cadena) {

        String[] vector = cadena.split("%");
        String nombre = vector[0];
        String apellido = vector[1];
        String dniString = vector[2];

        int DNI = Integer.parseInt(dniString);
        return new Socio(nombre, apellido, DNI);
    }
    public static Libro recuperarLibro(String cadena) {

        String[] vector = cadena.split("%");
        String nombre = vector[0];
        String autor = vector[1];
        String categoria = vector[2];
        String disponibilidad=vector[3];
        boolean disp=Boolean.parseBoolean(disponibilidad);
        return new Libro(nombre, autor,categoria,disp);
    }
    public static Pedido recuperarPedido(String cadena){
        String []vector=cadena.split("&");
        String fechaPrestamo=vector[0];
        LocalDate prestamo=LocalDate.parse(fechaPrestamo);
        String fechaDevolver=vector[1];
        LocalDate devolver=LocalDate.parse(fechaDevolver);
        String libro=vector[2];
        Libro LibroPedido=recuperarLibro(libro);
        String socio=vector[3];
        Socio SocioP=recuperarSocio(socio);

        return new Pedido(prestamo,devolver,LibroPedido,SocioP);
    }



}
