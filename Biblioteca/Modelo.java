package Biblioteca;

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

    public static void CargarArrays(ArrayList<Socio> Socios, ArrayList<Libro> Libros, ArrayList<Pedido> Pedidos) {
        /* Ahora recupero los arrays de String y los vuelvo a convertir en array de objetos.
         */
        //Cargo el array Socio-------------
        ArrayList<String> SociosCargados = GestorArchivos.cargarArray("ArraySocios.txt");

        for (int i = 0; i < SociosCargados.size(); i++) {

            Socio socio = Controlador.recuperarSocio(SociosCargados.get(i));
            Socios.add(socio);
        }
        //-----------------------------

        //Cargo el array de Libros
        ArrayList<String> LibrosCargados = GestorArchivos.cargarArray("ArrayLibros.txt");
        for (int i = 0; i < LibrosCargados.size(); i++) {
            Libro libro = Controlador.recuperarLibro(LibrosCargados.get(i));
            Libros.add(libro);
        }
        //-----------------------------

        //Cargo de array de Pedidos
        ArrayList<String> PedidosCargados = GestorArchivos.cargarArray("ArrayPedidos.txt");
        for (int i = 0; i < PedidosCargados.size(); i++) {
            Pedido pedido = Controlador.recuperarPedido(PedidosCargados.get(i));
            Pedidos.add(pedido);
        }
        //-----------------------------
    }



}
