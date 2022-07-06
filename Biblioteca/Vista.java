package Biblioteca;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;

public class Vista {


    public static int menu() {
        Scanner Leer = new Scanner(System.in);
        int eleccion;
        System.out.println("Programa de la biblioteca");
        System.out.println("----------------------------------");
        System.out.println("Seleccione su opción");
        System.out.println("[0]--> Salir");
        System.out.println("[1]--> Añadir un Socio");
        System.out.println("[2]--> Añadir un libro");
        System.out.println("[3]--> Ver socios");
        System.out.println("[4]--> Ver libros");
        System.out.println("[5]--> Eliminar Libro");
        System.out.println("[6]--> Eliminar Socio");
        System.out.println("[7]-->Pedir un libro");
        System.out.println("[8]-->Mostrar Pedidos");
        System.out.print("Ingrese su opción: ");
        eleccion = Leer.nextInt();
        System.out.println("----------------------------------");
        return eleccion;
    }

    public static Libro crearLibro() {

        Scanner Leer = new Scanner(System.in);
        boolean bandera = false;
        boolean disponibleLib = false;

        System.out.print("Ingrese el nombre del libro: ");
        Scanner LeerInt = new Scanner(System.in);
        String nombLib = Leer.nextLine();

        System.out.print("Ingrese su Autor: ");
        String autorLib = Leer.nextLine();

        System.out.print("Ingrese su categoria:");
        String categoriaLib = Leer.nextLine();

        while (bandera != true) {
            System.out.println("Ingrese su disponibiliada: ");
            System.out.println("[1]--> Disponible");
            System.out.println("[2]--> No Disponible");
            int eleccion = LeerInt.nextInt();
            if (eleccion == 1) {
                disponibleLib = true;
                bandera = true;
            } else if (eleccion == 2) {
                disponibleLib = false;
                bandera = true;
            } else {
                System.out.println("------------------------------------");
                System.out.println("Numero desconocio, vuelva a intentar");
                System.out.println("------------------------------------");
            }
        }
        Libro libro = new Libro(nombLib, autorLib, categoriaLib, disponibleLib);
        return libro;
    }

    public static Libro borrarLibro(ArrayList<Libro> Libros) {
        Scanner leerNumer = new Scanner(System.in);
        System.out.println("Borrar Libros");
        System.out.println("Seleccione el numero del Lbro:");
        for (int i = 0; i < Libros.size(); i++) {
            System.out.println("[" + i + "]--> " + Libros.get(i));
        }
        int numerLibro = leerNumer.nextInt();
        return Libros.get(numerLibro);
    }

    public static Socio crearSocio() {

        Scanner Leer = new Scanner(System.in);

        System.out.println("Igrese su nombre");
        String nombre = Leer.nextLine();
        System.out.println("Ingrese su apellido:");
        String apellido = Leer.nextLine();
        System.out.println("Ingrese su DNI:");
        int DNI = Leer.nextInt();

        Socio s = new Socio(nombre, apellido, DNI);
        return s;


    }

    public static Pedido crearPedido(ArrayList<Libro> Libros, ArrayList<Socio> Socios) {
        Scanner leerNumer = new Scanner(System.in);
        System.out.println("Registrar un pedido");
        LocalDate prestamoHoy=LocalDate.now();//Fecha de hoy
        LocalDate fechaDevolverLibro=LocalDate.now().plusDays(15);//Fecha de hoy mas 15 dias

        System.out.println("Seleccione el libro:");
        for (int i = 0; i < Libros.size(); i++) {
            if (Libros.get(i).getDisponibilidad() == true) {
                System.out.println("[" + i + "]-->" + Libros.get(i));
            }
        }
        int elecionLib = leerNumer.nextInt();
        Libros.get(elecionLib).setDisponibilidad(false);
        Libro libroElegido = Libros.get(elecionLib);

        System.out.println("Selecione el socio:");
        for (int i = 0; i < Socios.size(); i++) {
            System.out.println("[" + i + "]" + Socios.get(i));
        }
        int elecionSoci = leerNumer.nextInt();
        Socio socio = Socios.get(elecionSoci);

        Pedido pedido = new Pedido(prestamoHoy,fechaDevolverLibro , libroElegido, socio);
        return pedido;
    }
}
