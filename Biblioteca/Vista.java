package Biblioteca;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.*;
import java.util.logging.Level;

public class Vista {


    public static int menu() {
        Scanner Leer = new Scanner(System.in);
        int eleccion = 0;
        System.out.println("Programa de la biblioteca");
        System.out.println("----------------------------------");
        System.out.println("Seleccione su opción");
        System.out.println("[0]--> Salir");
        System.out.println("[1]--> Añadir un Socio");
        System.out.println("[2]--> Añadir un libro");
        System.out.println("[3]--> Ver socios");
        System.out.println("[4]--> Ver libros");
        System.out.println("[5]--> Dar de baja un Libro");
        System.out.println("[6]--> Dar de baja un Socio");
        System.out.println("[7]--> Pedir un libro");
        System.out.println("[8]--> Mostrar Pedidos");
        System.out.println("[9]--> Devolver libro");
        System.out.print("Ingrese su opción: ");
        boolean bandera = false;
        do {
            bandera = true;
            try {
                eleccion = Leer.nextInt();

            } catch (InputMismatchException e) {
                System.out.println("No debes ingresar letras o simbolos, vuelva a intentarlo:");
                bandera = false;
                Leer.nextLine();
            }
        } while (!bandera);
        return eleccion;

    }

    public static ArrayList crearLibro() {
        ArrayList<String> array = new ArrayList<>();
        Scanner Leer = new Scanner(System.in);

        System.out.print("Ingrese el nombre del libro: ");
        String nombLib = Leer.nextLine();
        array.add(nombLib);

        System.out.print("Ingrese su Autor: ");
        String autorLib = Leer.nextLine();
        array.add(autorLib);

        System.out.print("Ingrese su categoria:");
        String categoriaLib = Leer.nextLine();
        array.add(categoriaLib);

        return array;

    }

    public static int eleccionLibro(ArrayList<Libro> Libros) {
        boolean bandera = false;
        Scanner leerNumer = new Scanner(System.in);
        System.out.println("Seleccione el numero del Libro:");
        for (int i = 0; i < Libros.size(); i++) {
            System.out.println("[" + Libros.get(i).getLibroID() + "]--> " + Libros.get(i).getTituloDeLib()+" Disponible: "+Libros.get(i).isDisponibilidad());
        }
        int numerLibro = 0;
        do {
            bandera = true;
            try {
                numerLibro = leerNumer.nextInt();

            } catch (InputMismatchException e) {
                System.out.println("No debes ingresar letras o simbolos, vuelve a intentarlo:");
                bandera = false;
                leerNumer.nextLine();
            }
        } while (!bandera);
        return numerLibro;
    }


    public static int eleccionSocio(ArrayList<Socio> Socios) {
        int numerSocio = 0;
        Scanner leerNumer = new Scanner(System.in);
        System.out.println("Seleccione el numero del socio:");
        for (int i = 0; i < Socios.size(); i++) {
            System.out.println("[" + Socios.get(i).getSocioID() + "]--> " + Socios.get(i));
        }
        boolean bandera = false;
        do {
            bandera = true;
            try {
                numerSocio = leerNumer.nextInt();

            } catch (InputMismatchException e) {
                System.out.println("No debes ingresar letras o simbolos, vuelve a intentarlo:");
                bandera = false;
                leerNumer.nextLine();
            }
        } while (!bandera);

        return numerSocio;
    }

    public static ArrayList crearSocio() {
        ArrayList<String> atributosS = new ArrayList<>();

        Scanner Leer = new Scanner(System.in);

        System.out.println("Igrese su nombre");
        String nombre = Leer.nextLine();
        atributosS.add(nombre);

        System.out.println("Ingrese su apellido:");
        String apellido = Leer.nextLine();
        atributosS.add(apellido);

        System.out.println("Ingrese su DNI:");
        String DNI = Leer.nextLine();
        atributosS.add(DNI);


        return atributosS;


    }


    public static void mostrarLosSocios(ArrayList<Socio> socios) {
        System.out.println("o---o---o---o---o---o---o---o---o---o---o");
        for (int i = 0; i < socios.size(); i++) {
            System.out.println(socios.get(i));
        }
        System.out.println("o---o---o---o---o---o---o---o---o---o---o");
    }

    public static void mostrarLosLibros(ArrayList<Libro> Libros) {

        for (int i = 0; i < Libros.size(); i++) {
            System.out.println("o---o---o---o---o---o---o---o---o---o---o");
            System.out.println(Libros.get(i));
            System.out.println("o---o---o---o---o---o---o---o---o---o---o");
        }

    }

    public static void mostrarLosPedidos(ArrayList Pedidos) {
        for (int i = 0; i < Pedidos.size(); i++) {
            System.out.println("o---o---o---o---o---o---o---o---o---o---o");
            System.out.println(Pedidos.get(i));
            System.out.println("o---o---o---o---o---o---o---o---o---o---o");
        }
    }

    public static void validacionDeDatos(String resultado) {
        System.out.println(resultado);
    }

}
