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
        System.out.println("[5]--> Eliminar Libro");
        System.out.println("[6]--> Eliminar Socio");
        System.out.println("[7]--> Pedir un libro");
        System.out.println("[8]--> Mostrar Pedidos");
        System.out.println("[9]--> Devolver libro");
        System.out.print("Ingrese su opción: ");
        try {
            eleccion = Leer.nextInt();
        } catch (Exception e) {
            System.out.println("No debes ingresar letras o simbolos");
            eleccion = menu();
        }

        System.out.println("----------------------------------");
        return eleccion;

    }

    public static Libro crearLibro() {

        Scanner Leer = new Scanner(System.in);
        Scanner LeerInt = new Scanner(System.in);
        boolean bandera = false;
        boolean disponibleLib = false;
        String autorLib = "";
        String categoriaLib = "";
        String nombLib = "";


        System.out.print("Ingrese el nombre del libro: ");
        nombLib = Leer.nextLine();

        System.out.print("Ingrese su Autor: ");
        autorLib = Leer.nextLine();

        System.out.print("Ingrese su categoria:");
        categoriaLib = Leer.nextLine();
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
        boolean bandera = false;
        Scanner leerNumer = new Scanner(System.in);
        System.out.println("Borrar Libros");
        System.out.println("Seleccione el numero del Lbro:");
        for (int i = 0; i < Libros.size(); i++) {
            System.out.println("[" + i + "]--> " + Libros.get(i));
        }
        int numerLibro = 0;
        try {
            numerLibro = leerNumer.nextInt();

        } catch (InputMismatchException e) {
            System.out.println("No debes ingresar letras o simbolos");
            bandera = true;
        }
        if (bandera) {
            return null;
        } else {
            return Libros.get(numerLibro);
        }
    }

    public static int devolverLibro(ArrayList<Libro> Libros) {
        int numerLibro;
        Scanner leerNumer = new Scanner(System.in);
        System.out.println("Devolver Libros");
        System.out.println("Seleccione el numero del Lbro:");
        for (int i = 0; i < Libros.size(); i++) {
            if (Libros.get(i).getDisponibilidad() == false) {
                System.out.println("[" + i + "]--> " + Libros.get(i));
            }
        }
        try {
            numerLibro = leerNumer.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Debe ingresar un numero");
            numerLibro = devolverLibro(Libros);
        }

        return numerLibro;
    }

    public static Socio borrarSocio(ArrayList<Socio> Socios) {
        boolean fallo = false;
        int numerSocio = 0;
        Scanner leerNumer = new Scanner(System.in);
        System.out.println("Borrar socios");
        System.out.println("Seleccione el libro:");
        for (int i = 0; i < Socios.size(); i++) {
            System.out.println("[" + i + "]--> " + Socios.get(i));
        }
        try {
            numerSocio = leerNumer.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Debe ingresar un numero");
            fallo = true;
        }

        if (fallo) {
            return null;
        } else {
            return Socios.get(numerSocio);
        }
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
        LocalDate prestamoHoy = LocalDate.now();//Fecha de hoy
        LocalDate fechaDevolverLibro = LocalDate.now().plusDays(15);//Fecha de hoy mas 15 dias

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

        Pedido pedido = new Pedido(prestamoHoy, fechaDevolverLibro, libroElegido, socio);
        return pedido;
    }

    public static Socio recuperarSocio(String cadena) {
        Socio socio;

        String[] vector = cadena.split("%");
        String nombre = vector[0];
        String apellido = vector[1];
        String dniString = vector[2];

        int DNI = Integer.parseInt(dniString);
        return new Socio(nombre, apellido, DNI);
    }
    public static Libro recuperarLibro(String cadena) {

        String[] vector = cadena.split("%");
        String nombre = vector[0];
        String autor = vector[1];
        String categoria = vector[2];
        String disponibilidad=vector[3];
        boolean disp=Boolean.parseBoolean(disponibilidad);
        return new Libro(nombre, autor,categoria,disp);
    }
    public static Pedido recuperarPedido(String cadena){
        String []vector=cadena.split("&");
        String fechaPrestamo=vector[0];
        LocalDate prestamo=LocalDate.parse(fechaPrestamo);
        String fechaDevolver=vector[1];
        LocalDate devolver=LocalDate.parse(fechaDevolver);
        String libro=vector[2];
        Libro LibroPedido=Vista.recuperarLibro(libro);
        String socio=vector[3];
        Socio SocioP=Vista.recuperarSocio(socio);

        return new Pedido(prestamo,devolver,LibroPedido,SocioP);
    }

    public static ArrayList<String> CopiarDatos(ArrayList<Socio> arrayList) {
        ArrayList<String> arrayRetorno = new ArrayList<>();
        for (int i=0;i<arrayList.size();i++){
            arrayRetorno.add(arrayList.get(i).toString("%"));
        }

        return arrayRetorno;
    }
    public static ArrayList<String> CopiarDatosLibros(ArrayList<Libro> arrayList) {
        ArrayList<String> arrayRetorno = new ArrayList<>();

        for (int i=0;i<arrayList.size();i++){
            arrayRetorno.add(arrayList.get(i).toString("%"));
        }

        return arrayRetorno;
    }
    public static ArrayList<String> CopiarDatosPedidos(ArrayList<Pedido> arrayList) {
        ArrayList<String> arrayRetorno = new ArrayList<>();

        for (int i=0;i<arrayList.size();i++){
            arrayRetorno.add(arrayList.get(i).toString("&"));
        }

        return arrayRetorno;
    }

    public static void CargarArrays(ArrayList<Socio>Socios,ArrayList<Libro>Libros,ArrayList<Pedido>Pedidos){
        //Cargo el array Socio-------------
        ArrayList<String> SociosCargados=GestorArchivos.cargarArray("ArraySocios.txt");

        for (int i=0;i<SociosCargados.size();i++){
            Socio socio=Vista.recuperarSocio(SociosCargados.get(i));
            Socios.add(socio);
        }
        //-----------------------------

        ArrayList<String>LibrosCargados=GestorArchivos.cargarArray("ArrayLibros.txt");
        for (int i=0;i<LibrosCargados.size();i++){
            Libro libro=Vista.recuperarLibro(LibrosCargados.get(i));
            Libros.add(libro);
        }
       ArrayList<String>PedidosCargados=GestorArchivos.cargarArray("ArrayPedidos.txt");
        for (int i=0;i<PedidosCargados.size();i++){
            Pedido pedido=Vista.recuperarPedido(PedidosCargados.get(i));
            Pedidos.add(pedido);
        }
    }
}
