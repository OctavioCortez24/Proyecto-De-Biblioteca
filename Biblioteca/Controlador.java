package Biblioteca;

import java.time.LocalDate;
import java.util.*;

public class Controlador {


    public static void main(String[] args) {

        LibroEstado lE1 = new LibroEstado(1, "Ocupado");
        //  lE1.anadirLibroEstado();
        LibroEstado lE2 = new LibroEstado(2, "Disponible");
        // lE2.anadirLibroEstado();

        int eleccion = 0;
        //Menu
        do {
            //Cargo los array con la informacion que tengo almacenada en el archivo .txt.
            ArrayList<Libro> Libros = Modelo.cargarArrayDeObjetoLibro();
            ArrayList<Socio> Socios = Modelo.cargarArrayDeObjetoSocio();
            ArrayList<Pedido> Pedidos = Modelo.cargarArrayDeObjetoPedido();
            eleccion = Vista.menu();
            if (eleccion == 1) {

                System.out.println("Añadir un socio a la biblioteca");
                ArrayList<String> AtributosSocio = Vista.crearSocio();
                int DNI = Integer.parseInt(AtributosSocio.get(2));

                Socio socio1 = new Socio(Socios.size() + 1, AtributosSocio.get(0), AtributosSocio.get(1), DNI);//Instancio un socio
                if (socio1.validacion()){
                    Vista.validacionDeDatos("El Socio ya esta añadido");
                }else {

                    socio1.agregarSocio();
                    Vista.validacionDeDatos("Se añadio correctamente");
                }


            } else if (eleccion == 2) {

                System.out.println("Añadir un libro a la biblioteca");
                ArrayList<String> AtributosLi = Vista.crearLibro();
                int idLIbro=Libros.size() + 1;
                boolean disponibilidad = Boolean.parseBoolean(AtributosLi.get(3));

                Libro libro1 = new Libro(idLIbro ,AtributosLi.get(0), AtributosLi.get(1), AtributosLi.get(2), disponibilidad);//Instancio un libro
                if (libro1.validacion()){
                    Vista.validacionDeDatos("El libro ya se encuentra en la biblioteca");
                }else {
                    libro1.añadirLibro();//Añado el libro a la base de datos.
                    Vista.validacionDeDatos("El libro se añadio correctamente");
                }
                LibroEstado.EstadoLibro estadoLibro=new LibroEstado.EstadoLibro(LocalDate.now(),null,idLIbro,2);
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
                LibroEstado.EstadoLibro estadoLibro=new LibroEstado.EstadoLibro(LocalDate.now(),null,idLibro,1);
                estadoLibro.anadirEstadoLibro();
            } else if (eleccion == 8) {
                Vista.mostrarLosPedidos(Pedidos);

            } else if (eleccion == 9) {

                //Terminar
                System.out.println("Devolver Libros");
                int libro = Vista.eleccionLibro(Libros);

                //Pedido.devolverLibro(libro);

            }

        } while (eleccion != 0);
    }


}
