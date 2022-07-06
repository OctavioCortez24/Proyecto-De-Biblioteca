package Biblioteca;

import java.util.*;

public class Controlador {
    public static void main(String[] args) {
        Filial Filial1 = new Filial("Biblioteca 1");
        //Codigo para no ingresar contastemente Socios y libros
        Socio s = new Socio("Octavio", "Cortez", 43213252);
        Socio s2 = new Socio("Leandro", "Cortez", 45876507);
        Filial1.anadirSocio(s);
        Filial1.anadirSocio(s2);
        Libro l = new Libro("El principito", "Antoine de Saint-Exupéry", "Fabula", true);
        Libro l2 = new Libro("La odisea", "Homero", "Poesia", true);
        Filial1.anadirLibro(l);
        Filial1.anadirLibro(l2);
        //-----------------------------------------------------------------

        ArrayList<Libro> LibrosFilial = Filial1.getLibros();
        ArrayList<Socio> SociosFilial = Filial1.getSocios();
        //Arriba lo que hago es traerme los arrays Libros y Socios de el objeto Filial1, para poder ocuparlo abajo

        int eleccion = 0;
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
            } else if(eleccion==6){
                Socio socio=Vista.borrarSocio(SociosFilial);
                Filial1.borrarSocio(socio);
            }else if (eleccion == 7) {
                Pedido p = Vista.crearPedido(LibrosFilial, SociosFilial);
                Filial1.anadirPedido(p);

            } else if (eleccion == 8) {
                Filial1.mostrarPedidos();
            }else if(eleccion==9){
                int libro=Vista.devolverLibro(LibrosFilial);
                Filial1.devolverLibro(libro);
            }

        } while (eleccion != 0);
    }
}
