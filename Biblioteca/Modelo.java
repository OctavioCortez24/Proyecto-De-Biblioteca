package Biblioteca;

import java.util.ArrayList;

public class Modelo {
    public static void CargarArrays(ArrayList<Socio> Socios, ArrayList<Libro> Libros, ArrayList<Pedido> Pedidos) {
        //Cargo el array Socio-------------
        ArrayList<String> SociosCargados = GestorArchivos.cargarArray("ArraySocios.txt");

        for (int i = 0; i < SociosCargados.size(); i++) {
            Socio socio = Controlador.recuperarSocio(SociosCargados.get(i));
            Socios.add(socio);
        }
        //-----------------------------

        ArrayList<String> LibrosCargados = GestorArchivos.cargarArray("ArrayLibros.txt");
        for (int i = 0; i < LibrosCargados.size(); i++) {
            Libro libro = Controlador.recuperarLibro(LibrosCargados.get(i));
            Libros.add(libro);
        }
        ArrayList<String> PedidosCargados = GestorArchivos.cargarArray("ArrayPedidos.txt");
        for (int i = 0; i < PedidosCargados.size(); i++) {
            Pedido pedido = Controlador.recuperarPedido(PedidosCargados.get(i));
            Pedidos.add(pedido);
        }
    }

    public static void GuardarPedidos(ArrayList<Pedido> Pedidos) {
        /*Debo copiar los datos de mis arrays de pedido porque el metodo de gestor de archivos, guardar ayrray,
        solamente permite array de tipo String.
         */
        //Copio los datos del Array de Pedidos a un array de String
        ArrayList<String> PedidosString = Controlador.CopiarDatosPedidos(Pedidos);
        GestorArchivos.guardarArray(PedidosString, "ArrayPedidos.txt");
    }

    public static void GuardarSocios(ArrayList<Socio> Socios) {
        /*Debo copiar los datos de mis arrays de socio porque el metodo de gestor de archivos, guardar ayrray,
        solamente permite array de tipo String.
         */

        //Copio los datos del Array de Socios a un array de String
        ArrayList<String> SociosString = Controlador.CopiarDatos(Socios);

        //Guardo los arrays de String
        GestorArchivos.guardarArray(SociosString, "ArraySocios.txt");
    }

    public static void GuardarLibros(ArrayList<Libro> Libros) {
        /*Debo copiar los datos de mis arrays de libro porque el metodo de gestor de archivos, guardar ayrray,
        solamente permite array de tipo String.
         */
        //Copio los datos del Array de Libros a un array de String
        ArrayList<String> LibrosString = Controlador.CopiarDatosLibros(Libros);
        GestorArchivos.guardarArray(LibrosString, "ArrayLibros.txt");
    }

}
