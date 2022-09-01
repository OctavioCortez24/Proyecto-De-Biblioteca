package Biblioteca;

import java.time.LocalDate;
import java.util.*;

public class Controlador {
    public Controlador() {
    }

    public static void main(String[] args) {
        Filial Filial1 = new Filial("Biblioteca 1");
        ArrayList<Libro> LibrosFilial = Filial1.getLibros();//Creo el array de Libros
        ArrayList<Socio> SociosFilial = Filial1.getSocios();//Creo el array de Socios
        ArrayList<Pedido> PedidosFilial=Filial1.getPedidos();//Creo el array de Pedidos

        Modelo.CargarArrays(SociosFilial,LibrosFilial,PedidosFilial);



        int eleccion = 0;
        //Menu
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
            } else if (eleccion == 5) {
                Libro libro = Vista.borrarLibro(LibrosFilial);
                Filial1.borrarLibro(libro);
            } else if (eleccion == 6) {
                Socio socio = Vista.borrarSocio(SociosFilial);
                Filial1.borrarSocio(socio);
            } else if (eleccion == 7) {
                Pedido p = Vista.crearPedido(LibrosFilial, SociosFilial);
                Filial1.anadirPedido(p);

            } else if (eleccion == 8) {
                Filial1.mostrarPedidos();
            } else if (eleccion == 9) {
                int libro = Vista.devolverLibro(LibrosFilial);
                Filial1.devolverLibro(libro);
            }

        } while (eleccion != 0);

        Modelo.GuardarDatos(SociosFilial,LibrosFilial,PedidosFilial);
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

}
