package Biblioteca;
import java.util.*;
public class Controlador {
    public static void main(String[] args) {
        ArrayList<Libro>Libros=new ArrayList<>();
        ArrayList<Socio>Socios=new ArrayList<>();
        ArrayList<Pedido>Pedidos=new ArrayList<>();
        //Codigo para no ingresar contastemente Socios y libros
        Socio s=new Socio("Octavio","Cortez", 43213252);
        Socio s2=new Socio("Leandro","Cortez", 45876507);
        Socios.add(s);
        Socios.add(s2);
        Libro l=new Libro("El principito","Antoine de Saint-Exupéry","Fabula",true);
        Libro l2=new Libro("La odisea","Homero","Poesia",true);
        Libros.add(l);
        Libros.add(l2);
        //-----------------------------------------------------------------
        Filial Filial1= new Filial("Biblioteca 1");
        int eleccion=0;
        do {
            eleccion = Vista.menu();
            if (eleccion == 1) {
                Socio socio1 = Vista.crearSocio();
                Filial1.anadirSocio(socio1);
            } else if (eleccion == 2) {
                Libro libro1 = Vista.crearLibro();
                Filial1.anadirLibro(libro1);
            } else if (eleccion == 3) {
                Filial1.mostrarSocio();
            } else if (eleccion == 4) {
                Filial1.mostrarLibro();
            }else if(eleccion==5){

              //Teminar----------
            }else if(eleccion==6){
                Pedido p=Vista.crearPedido(Libros,Socios);
                Pedidos.add(p);
            }else if(eleccion==7){
              Filial1.mostrarPedidos();
            }

        } while (eleccion != 0);
    }
}
