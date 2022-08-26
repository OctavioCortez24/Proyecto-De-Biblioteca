package Biblioteca;

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

        String Libros=GestorArchivos.cargar("ArrayLibros.txt");
        System.out.println(Libros);
        String []vector=Libros.split("#");
        for (int i=0;i< vector.length;i++){
            System.out.println(vector[i]);
        }


    }
}
