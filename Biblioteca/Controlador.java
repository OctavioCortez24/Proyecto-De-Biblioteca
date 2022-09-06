package Biblioteca;

import java.time.LocalDate;
import java.util.*;

public class Controlador {
    public Controlador() {
    }

    public static void main(String[] args) {
        Filial Filial1 = new Filial("Biblioteca 1");//Instancio un objeto filial
        ArrayList<Libro> LibrosFilial = Filial1.getLibros();//Creo el array de Libros
        ArrayList<Socio> SociosFilial = Filial1.getSocios();//Creo el array de Socios
        ArrayList<Pedido> PedidosFilial=Filial1.getPedidos();//Creo el array de Pedidos

        //Cargo los array con la informacion que tengo almacenada en el archivo .txt.
        Modelo.CargarSocios(SociosFilial);
        Modelo.CargarLibros(LibrosFilial);
        Modelo.CargarPedidos(PedidosFilial);



        int eleccion = 0;
        //Menu
        do {
            eleccion = Vista.menu();
            if (eleccion == 1) {
                Socio socio1 = Vista.crearSocio();
                Filial1.anadirSocio(socio1);
                Modelo.GuardarSocios(SociosFilial);
            } else if (eleccion == 2) {
                Libro libro1 = Vista.crearLibro();
                Filial1.anadirLibro(libro1);
                Modelo.GuardarLibros(LibrosFilial);
            } else if (eleccion == 3) {
                Filial1.mostrarSocio();
            } else if (eleccion == 4) {
                Filial1.mostrarLibro();
            } else if (eleccion == 5) {
                Libro libro = Vista.eleccionLibro(LibrosFilial);
                Filial1.borrarLibro(libro);
                Modelo.GuardarLibros(LibrosFilial);
                System.out.println("Libro borrado con exito");
            } else if (eleccion == 6) {
                Socio socio = Vista.eleccionSocio(SociosFilial);
                Filial1.borrarSocio(socio);
                Modelo.GuardarSocios(SociosFilial);
                System.out.println("Socio borrado con exito");
            } else if (eleccion == 7) {
                Pedido p = Vista.crearPedido(LibrosFilial, SociosFilial);
                Filial1.anadirPedido(p);
                Modelo.GuardarPedidos(PedidosFilial);
            } else if (eleccion == 8) {
                Filial1.mostrarPedidos();
            } else if (eleccion == 9) {
                int libro = Vista.devolverLibro(LibrosFilial);
                Filial1.devolverLibro(libro);
                Modelo.GuardarLibros(LibrosFilial);
            }

        } while (eleccion != 0);
    }




}
