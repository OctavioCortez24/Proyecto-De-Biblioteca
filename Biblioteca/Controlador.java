package Biblioteca;

import java.time.LocalDate;
import java.util.*;

public class Controlador {


    public static void main(String[] args) {
        Filial Filial1 = new Filial("Biblioteca 1");//Instancio un objeto filial
        ArrayList<Libro> LibrosFilial = Filial1.getLibros();//array de Libros de la Filial 1
        ArrayList<Socio> SociosFilial = Filial1.getSocios();//array de Socios de la Filial 1
        ArrayList<Pedido> PedidosFilial = Filial1.getPedidos();//array de Pedidos de la Filial 1

        //Cargo los array con la informacion que tengo almacenada en el archivo .txt.
        Modelo.CargarSocios(SociosFilial);
        Modelo.CargarLibros(LibrosFilial);
        Modelo.CargarPedidos(PedidosFilial);


        int eleccion = 0;
        //Menu
        do {
            eleccion = Vista.menu();
            if (eleccion == 1) {

                ArrayList<String> AtributosSocio = Vista.crearSocio();
                String nombre=AtributosSocio.get(0);
                String apellido=AtributosSocio.get(1);
                int DNI=Integer.parseInt(AtributosSocio.get(2));

                Socio socio1 = new Socio(nombre,apellido,DNI);//Instancio un socio
                Filial1.anadirSocio(socio1);

            } else if (eleccion == 2) {

                ArrayList<String> LibrosAtributos = Vista.crearLibro();
                String titulo = LibrosAtributos.get(0);
                String autor = LibrosAtributos.get(1);
                String categoria = LibrosAtributos.get(2);
                boolean disponibilidad = Boolean.parseBoolean(LibrosAtributos.get(3));

                Libro libro1 = new Libro(titulo, autor, categoria, disponibilidad);//Instancio un libro
                Filial1.anadirLibro(libro1);

            } else if (eleccion == 3) {

                Filial1.mostrarSocio();

            } else if (eleccion == 4) {

                Filial1.mostrarLibro();

            } else if (eleccion == 5) {

                System.out.println("Borrar Libros");
                int numeroLibro = Vista.eleccionLibro(LibrosFilial);
                Filial1.borrarLibro(numeroLibro);
                System.out.println("Libro borrado con exito");

            } else if (eleccion == 6) {

                System.out.println("Borrar socios");
                int numeroSocio = Vista.eleccionSocio(SociosFilial);
                Filial1.borrarSocio(numeroSocio);
                System.out.println("Socio borrado con exito");

            } else if (eleccion == 7) {
                System.out.println("Registrar un pedido");

                LocalDate prestamoHoy = LocalDate.now();//Fecha de hoy
                LocalDate fechaDevolverLibro = LocalDate.now().plusDays(15);//Fecha de hoy mas 15 dias
                //Libro
                int numeroLibro=Vista.eleccionLibro(LibrosFilial);
                Libro libro=LibrosFilial.get(numeroLibro);
                //-----
                //Socio
                int numeroSocio=Vista.eleccionSocio(SociosFilial);
                Socio socio=SociosFilial.get(numeroSocio);
                //------
                Pedido p = new Pedido(prestamoHoy,fechaDevolverLibro,libro,socio);//Instancio un pedido
                Filial1.anadirPedido(p);

            } else if (eleccion == 8) {
                Filial1.mostrarPedidos();

            } else if (eleccion == 9) {

                System.out.println("Devolver Libros");
                int libro = Vista.eleccionLibro(LibrosFilial);

                Filial1.devolverLibro(libro);

            }
            Modelo.GuardarLibros(LibrosFilial);
            Modelo.GuardarPedidos(PedidosFilial);
            Modelo.GuardarSocios(SociosFilial);

        } while (eleccion != 0);
    }


}
