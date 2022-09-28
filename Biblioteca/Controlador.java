package Biblioteca;

import java.time.LocalDate;
import java.util.*;

public class Controlador {


    public static void main(String[] args) {

        int eleccion = 0;
        //Menu
        do {
            //Cargo los array con la informacion que tengo almacenada en el archivo .txt.
            eleccion = Vista.menu();
            if (eleccion == 1) {

                System.out.println("Añadir un socio a la biblioteca");
                ArrayList<String> AtributosSocio = Vista.crearSocio();
                int DNI = Integer.parseInt(AtributosSocio.get(2));
                int idSocio = Modelo.cargarArrayDeObjetoSocio().size() + 1;

                Socio socio1 = new Socio(idSocio, AtributosSocio.get(0), AtributosSocio.get(1), DNI, false);//Instancio un socio
                //Compruebo si el socio se encuentra en la BD
                if (socio1.validacion()) {
                    Vista.validacionDeDatos("El Socio ya esta añadido");
                } else {
                    socio1.agregarSocio();
                    Vista.validacionDeDatos("Se añadio correctamente");
                }


            } else if (eleccion == 2) {

                System.out.println("Añadir un libro a la biblioteca");
                ArrayList<String> AtributosLi = Vista.crearLibro();
                int idLIbro = Modelo.cargarArrayDeObjetoLibro().size() + 1;

                Libro libro1 = new Libro(idLIbro, AtributosLi.get(0), AtributosLi.get(1), AtributosLi.get(2), true, false);//Instancio un libro

                //Compruebo si el libro se encuentra en la BD
                if (libro1.validacion()) {
                    Vista.validacionDeDatos("El libro ya se encuentra en la biblioteca");
                } else {
                    libro1.añadirLibro();//Añado el libro a la base de datos.
                    Vista.validacionDeDatos("El libro se añadio correctamente");
                }

            } else if (eleccion == 3) {

                Vista.mostrarLosSocios(Modelo.cargarArrayDeObjetoSocio());//Preguntar si esto esta bien

            } else if (eleccion == 4) {

                Vista.mostrarLosLibros(Modelo.cargarArrayDeObjetoLibro());//Preguntar si esto esta bien

            } else if (eleccion == 5) {
                //Terminar
                System.out.println("Dar de baja un libro");
                int numeroLibro = Vista.eleccionLibro(Modelo.cargarArrayDeObjetoLibro());
                //Libros.get(numeroLibro).darDeBaja();
                System.out.println("El libro se dio de baja correctamente");

            } else if (eleccion == 6) {

                //Terminar
                System.out.println("Dar de baja un socio");
                int numeroSocio = Vista.eleccionSocio(Modelo.cargarArrayDeObjetoSocio());
                // Socios.get(numeroSocio).darDeBaja();
                System.out.println("Socio borrado con exito");

            } else if (eleccion == 7) {
                System.out.println("Registrar un pedido");
                //Libro
                int idLibro = Vista.eleccionLibro(Modelo.cargarArrayDeObjetoLibro());//Preguntar si esto esta bien
                //-----
                //Socio
                int idSocio = Vista.eleccionSocio(Modelo.cargarArrayDeObjetoSocio());//Preguntar si esto esta bien
                //------
                Pedido p = new Pedido(LocalDate.now(), LocalDate.now().plusDays(15), idLibro, idSocio);//Instancio un pedido
                p.anadirPedido();
            } else if (eleccion == 8) {
                Vista.mostrarLosPedidos(Modelo.cargarArrayDeObjetoPedido());

            } else if (eleccion == 9) {

                //Terminar
                System.out.println("Devolver Libros");
                int libro = Vista.eleccionLibro(Modelo.cargarArrayDeObjetoLibro());

                //Pedido.devolverLibro(libro);

            }

        } while (eleccion != 0);
    }


}
