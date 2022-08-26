package Biblioteca;

import java.time.LocalDate;
import java.util.*;

public class Controlador {
    public Controlador() {
    }

    public static void main(String[] args) {
        Filial Filial1 = new Filial("Biblioteca 1");
        ArrayList<Libro> LibrosFilial = Filial1.getLibros();//Creo el array de Libros
        ArrayList<Socio> SociosFilial = Filial1.getSocios();//Creo el array de Socios
        ArrayList<Pedido> PedidosFilial=Filial1.getPedidos();//Creo el array de Pedidos
        ArrayList<String>SociosString;
        ArrayList<String>LibrosString;
        ArrayList<String>PedidosString;

        Vista.CargarArrays(SociosFilial,LibrosFilial,PedidosFilial);




        int eleccion = 0;
        //Menu
        do {
            eleccion = Vista.menu();
            if (eleccion == 1) {
                Socio socio1 = Vista.crearSocio();
                Filial1.anadirSocio(socio1);
            } else if (eleccion == 2) {
                Libro libro1 = Vista.crearLibro();
                Filial1.anadirLibro(libro1);
            } else if (eleccion == 3) {
                Filial1.mostrarSocio();
            } else if (eleccion == 4) {
                Filial1.mostrarLibro();
            } else if (eleccion == 5) {
                Libro libro = Vista.borrarLibro(LibrosFilial);
                Filial1.borrarLibro(libro);
            } else if (eleccion == 6) {
                Socio socio = Vista.borrarSocio(SociosFilial);
                Filial1.borrarSocio(socio);
            } else if (eleccion == 7) {
                Pedido p = Vista.crearPedido(LibrosFilial, SociosFilial);
                Filial1.anadirPedido(p);

            } else if (eleccion == 8) {
                Filial1.mostrarPedidos();
            } else if (eleccion == 9) {
                int libro = Vista.devolverLibro(LibrosFilial);
                Filial1.devolverLibro(libro);
            }

        } while (eleccion != 0);

        //Guardo el array de Socios
        SociosString=Vista.CopiarDatos(SociosFilial);
        GestorArchivos.guardarArray(SociosString,"ArraySocios.txt");
        //Guardo el array de libros
        LibrosString=Vista.CopiarDatosLibros(LibrosFilial);
        GestorArchivos.guardarArray(LibrosString,"ArrayLibros.txt");
        //Guardo el array de pedidos
        PedidosString=Vista.CopiarDatosPedidos(PedidosFilial);
        GestorArchivos.guardarArray(PedidosString,"ArrayPedidos.txt");
    }
}
