package Biblioteca;

import java.util.*;

public class Controlador {
    public Controlador() {
    }

    public static void main(String[] args) {
        Filial Filial1 = new Filial("Biblioteca 1");
        ArrayList<Libro> LibrosFilial = Filial1.getLibros();
        ArrayList<Socio> SociosFilial = Filial1.getSocios();

        //Arriba lo que hago es traerme los arrays Libros y Socios de el objeto Filial1, para poder ocuparlo abajo

        ArrayList<String>SociosString=new ArrayList<>();
        for (int i=0;i<SociosFilial.size();i++){
            SociosString.add(SociosFilial.get(i).toString());
        }
        int eleccion = 0;
        //Menu
        do {
            GestorArchivos.guardarArray(SociosString,"GuardarSocios.txt");
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
    }
}
