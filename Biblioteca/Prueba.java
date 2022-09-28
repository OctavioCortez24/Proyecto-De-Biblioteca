package Biblioteca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLOutput;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.*;

public class Prueba {
    public static void main(String[] args) {
        ArrayList<String>arrayList=new ArrayList<>();
        arrayList.add("Prueba1");
        arrayList.add("Prueba2");
        arrayList.add("Prueba3");

        GestorArchivos.guardar("Prueba.txt",GestorArchivos.empaquetador(arrayList,"#\n"));

        String p=GestorArchivos.cargar("Prueba.txt");
        System.out.println(p);
        arrayList=GestorArchivos.desempaquetador(p,"#");



        for (int i=0;i< arrayList.size();i++){
            System.out.println(arrayList.get(i));
        }

    }

   /* public static Pedido crearPedido(ArrayList<Libro> Libros, ArrayList<Socio> Socios) {
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


        return new Pedido(prestamoHoy, fechaDevolverLibro, libroElegido, socio);
    }*/

    public static int devolverLibro(ArrayList<Libro> Libros) {
        int numerLibro = 0;
        Scanner leerNumer = new Scanner(System.in);
        System.out.println("Seleccione el numero del Lbro:");
        for (int i = 0; i < Libros.size(); i++) {
            if (Libros.get(i).isDisponibilidad() == false) {
                System.out.println("[" + i + "]--> " + Libros.get(i));
            }
        }
        boolean bandera = false;
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
}
