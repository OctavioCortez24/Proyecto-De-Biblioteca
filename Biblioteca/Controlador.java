package Biblioteca;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.sql.*;

public class Controlador {


    public static void main(String[] args) {

        //Cargo los array con la informacion que tengo almacenada en el archivo .txt.
        ArrayList<Libro> Libros = Modelo.cargarArrayDeObjetoLibro();
        ArrayList<Socio> Socios = Modelo.cargarArrayDeObjetoSocio();
        ArrayList<Pedido> Pedidos = Modelo.cargarArrayDeObjetoPedido();

        LibroEstado lE1 = new LibroEstado(1, "Ocupado");
        //  lE1.anadirLibroEstado();
        LibroEstado lE2 = new LibroEstado(2, "Disponible");
        // lE2.anadirLibroEstado();
        LibroEstado lE3 = new LibroEstado(3, "Desactivado");
        // lE3.anadirLibroEstado();

        int eleccion = 0;
        //Menu
        do {
            eleccion = Vista.menu();
            if (eleccion == 1) {

                System.out.println("Añadir un socio a la biblioteca");
                ArrayList<String> AtributosSocio = Vista.crearSocio();
                int DNI = Integer.parseInt(AtributosSocio.get(2));

                Socio socio1 = new Socio(Socios.size() + 1, AtributosSocio.get(0), AtributosSocio.get(1), DNI);//Instancio un socio
                socio1.agregarSocio();

            } else if (eleccion == 2) {

                System.out.println("Añadir un libro a la biblioteca");
                ArrayList<String> AtributosLi = Vista.crearLibro();
                int idLIbro=Libros.size() + 1;
                boolean disponibilidad = Boolean.parseBoolean(AtributosLi.get(3));

                Libro libro1 = new Libro(idLIbro ,AtributosLi.get(0), AtributosLi.get(1), AtributosLi.get(2), disponibilidad);//Instancio un libro
                libro1.añadirLibro();//Añado el libro a la base de datos.
                EstadoLibro estadoLibro=new EstadoLibro(LocalDate.now(),null,idLIbro,2);
                estadoLibro.anadirEstadoLibro();
            } else if (eleccion == 3) {

                Vista.mostrarLosSocios(Socios);//Preguntar si esto esta bien

            } else if (eleccion == 4) {

                Vista.mostrarLosLibros(Libros);//Preguntar si esto esta bien

            } else if (eleccion == 5) {
                //Terminar
                System.out.println("Dar de baja un libro");
                int numeroLibro = Vista.eleccionLibro(Libros);
                Libros.get(numeroLibro).darDeBaja();
                System.out.println("El libro se dio de baja correctamente");

            } else if (eleccion == 6) {

                //Terminar
                System.out.println("Dar de baja un socio");
                int numeroSocio = Vista.eleccionSocio(Socios);
                Socios.get(numeroSocio).darDeBaja();
                System.out.println("Socio borrado con exito");

            } else if (eleccion == 7) {
                System.out.println("Registrar un pedido");
                //Libro
                int idLibro = Vista.eleccionLibro(Libros);//Preguntar si esto esta bien
                //-----
                //Socio
                int idSocio = Vista.eleccionSocio(Socios);//Preguntar si esto esta bien
                //------
                Pedido p = new Pedido(LocalDate.now(), LocalDate.now().plusDays(15), idLibro, idSocio);//Instancio un pedido
                p.anadirPedido();

            } else if (eleccion == 8) {
                Vista.mostrarLosPedidos(Pedidos);

            } else if (eleccion == 9) {

                //Terminar
                System.out.println("Devolver Libros");
                int libro = Vista.eleccionLibro(Libros);

                //Pedido.devolverLibro(libro);

            }

        } while (eleccion != 0);

        try {
            Conexion.cerrarConexion();
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexion con la base de datos");
            throw new RuntimeException(e);
        }

    }


}
