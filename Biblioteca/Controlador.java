package Biblioteca;

import java.time.LocalDate;
import java.util.*;
import java.sql.*;

public class Controlador {


    public static void main(String[] args) {

        //Cargo los array con la informacion que tengo almacenada en el archivo .txt.
        ArrayList<Libro> Libros = Modelo.cargarArrayDeObjetoLibro();
        ArrayList<Socio> Socios = Modelo.cargarArrayDeObjetoSocio();
        ArrayList<Pedido> Pedidos;

        int eleccion = 0;
        //Menu
        do {
            eleccion = Vista.menu();
            if (eleccion == 1) {

                System.out.println("Añadir un socio a la biblioteca");
                ArrayList<String> AtributosSocio = Vista.crearSocio();
                String nombre = AtributosSocio.get(0);
                String apellido = AtributosSocio.get(1);
                int DNI = Integer.parseInt(AtributosSocio.get(2));

                Socio socio1 = new Socio(nombre, apellido, DNI);//Instancio un socio
                socio1.agregarSocio();

            } else if (eleccion == 2) {

                System.out.println("Añadir un libro a la biblioteca");
                ArrayList<String> LibrosAtributos = Vista.crearLibro();
                String titulo = LibrosAtributos.get(0);
                String autor = LibrosAtributos.get(1);
                String categoria = LibrosAtributos.get(2);
                boolean disponibilidad = Boolean.parseBoolean(LibrosAtributos.get(3));

                Libro libro1 = new Libro(titulo, autor, categoria, disponibilidad);//Instancio un libro

                libro1.añadirLibro();

            } else if (eleccion == 3) {

                Vista.mostrarLosSocios(Socios);

            } else if (eleccion == 4) {

               Vista.mostrarLosLibros(Libros);

            } else if (eleccion == 5) {

                System.out.println("Borrar Libros");
                // int numeroLibro = Vista.eleccionLibro();

                System.out.println("Libro borrado con exito");

            } else if (eleccion == 6) {

                System.out.println("Borrar socios");
                //int numeroSocio = Vista.eleccionSocio(Modelo.getSocios());
                // Modelo.borrarSocio(numeroSocio);


            } else if (eleccion == 7) {
                System.out.println("Registrar un pedido");
                //Libro
                int numeroLibro = Vista.eleccionLibro(Libros);
                Libro libro = Libros.get(numeroLibro);
                //-----
                //Socio
                int numeroSocio = Vista.eleccionSocio(Socios);
                Socio socio = Socios.get(numeroSocio);
                //------
                Pedido p = new Pedido(LocalDate.now(), LocalDate.now().plusDays(15), libro, socio);//Instancio un pedido
                p.anadirPedido();

            } else if (eleccion == 8) {
                //   Vista.mostrarLosPedidos();

            } else if (eleccion == 9) {

                System.out.println("Devolver Libros");
                // int libro = Vista.eleccionLibro(Modelo.getLibros());

                //Pedido.devolverLibro(libro);

            }

        } while (eleccion != 0);

    }


}
