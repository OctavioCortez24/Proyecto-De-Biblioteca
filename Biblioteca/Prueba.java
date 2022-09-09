package Biblioteca;

import java.time.LocalDate;
import java.util.*;

public class Prueba {
    public static void main(String[] args) {
       /*Filial Filial1 = new Filial();
        Socio s = new Socio("Octavio", "Cortez", 43213252);
        Socio s2 = new Socio("Leandro", "Cortez", 45876507);
        Socio s3 = new Socio("Patricia", "Castro", 29576507);

        Filial1.anadirSocio(s);
        Filial1.anadirSocio(s2);
        Filial1.anadirSocio(s3);

        Libro l = new Libro("El principito", "Antoine de Saint-Exupéry", "Fabula", true);
        Libro l2 = new Libro("La odisea", "Homero", "Poesia", true);
        Filial1.anadirLibro(l);
        Filial1.anadirLibro(l2);
        ArrayList<Libro> LibrosFilial = Filial1.getLibros();//Arrays de Libros de la bilblioteca
        ArrayList<Socio> SociosFilial = Filial1.getSocios();//Arrays de socios de la biblioteca

        ArrayList<String>PruebaSociosStr= new ArrayList<>();// Array de prueba
        for (int i=0;i<SociosFilial.size();i++){
            PruebaSociosStr.add(SociosFilial.get(i).toString());// Estoy copiando los datos del array de socios al array de String
        }



        GestorArchivos.guardarArray(PruebaSociosStr,"ArraySocios.txt");//Guardo el array de los socios


        ArrayList<String> ArrayRecuperadoSoc=GestorArchivos.cargarArray("ArraySocios.txt");

        ArrayList<Socio>SociosRecuperados=new ArrayList<>();

        for (int i=0;i<ArrayRecuperadoSoc.size();i++){
            SociosRecuperados.add(Vista.recuperarSocio(ArrayRecuperadoSoc.get(i)));
            System.out.println(SociosRecuperados.get(i));
        }*/

      /*  String Libros=GestorArchivos.cargar("ArrayLibros.txt");
        System.out.println(Libros);
        String []vector=Libros.split("#");
        for (int i=0;i< vector.length;i++){
            System.out.println(vector[i]);
        }*/
        /*Scanner leerNumer=new Scanner(System.in);
        boolean bandera=false;
        int numerLibro=0;
        do {


            System.out.println("Ingrese un valor:");
            bandera=true;
            try {
                numerLibro = leerNumer.nextInt();

            } catch (InputMismatchException e) {
                System.out.println("No debes ingresar letras o simbolos");
                bandera=false;
                leerNumer.nextLine();
            }
        }while (!bandera);*/

       /* Libro l=new Libro("The Book","Carlos","Fantasia",true);
        Libro l2=new Libro("The Book","Carlos","Fantasia",true);
        Libro l3=new Libro("The Book 2","Carlos","Fantasia",true);

        System.out.println("Son iguales l y l2 :"+l.equals(l2));
        System.out.println("Son iguales l y l3 :"+l.equals(l3));*/


        Socio s=new Socio("Juan","Castro",1234);
        Socio s2=new Socio("Juan","Castro",1234);
        Socio s3=new Socio("JuanL","Castro",1234);

        ArrayList<Socio>socios=new ArrayList<>();
        socios.add(s);
        socios.add(s2);
        socios.add(s3);

        Socio s4=new Socio("Juan","Castro",1234);
        for (int i=0;i<socios.size();i++){
            if (s4.equals(socios.get(i))){
                System.out.println(s4+" y "+ socios.get(i)+" Son iguales");
            }
        }

        String r;
        boolean b=false;
        r=b?"ddd":"dw";

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


        return new Pedido(prestamoHoy, fechaDevolverLibro, libroElegido, socio);
    }
    public static int devolverLibro(ArrayList<Libro> Libros) {
        int numerLibro = 0;
        Scanner leerNumer = new Scanner(System.in);
        System.out.println("Seleccione el numero del Lbro:");
        for (int i = 0; i < Libros.size(); i++) {
            if (Libros.get(i).getDisponibilidad() == false) {
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
