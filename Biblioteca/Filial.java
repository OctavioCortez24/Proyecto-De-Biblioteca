package Biblioteca;

import java.util.ArrayList;

public class Filial {
    private String nombreFilial;
    private ArrayList<Pedido> Pedidos = new ArrayList<>();
    private ArrayList<Libro> Libros = new ArrayList<>();
    private ArrayList<Socio> Socios = new ArrayList<>();

    public Filial() {

    }

    public Filial(String n) {
        this.nombreFilial = n;
    }

    public void setNombreFilial(String nombreFilial) {
        this.nombreFilial = nombreFilial;
    }

    public String getNombreFilial() {
        return nombreFilial;
    }

    public ArrayList<Pedido> getPedidos() {
        return Pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        Pedidos = pedidos;
    }

    public ArrayList<Libro> getLibros() {
        return Libros;
    }

    public void setLibros(ArrayList<Libro> libros) {
        Libros = libros;
    }

    public ArrayList<Socio> getSocios() {
        return Socios;
    }

    public void setSocios(ArrayList<Socio> socios) {
        Socios = socios;
    }

    public void anadirLibro(Libro l) {
        Libros.add(l);
    }
    public void devolverLibro(int l){
        Libros.get(l).setDisponibilidad(true);
    }

    public void anadirSocio(Socio s) {
        Socios.add(s);
    }

    public void anadirPedido(Pedido p) {
        Pedidos.add(p);
    }

    public void borrarLibro(Libro l) {
        Libros.remove(l);
    }

    public void borrarSocio(Socio s) {
        Socios.remove(s);
    }

    public void mostrarSocio() {
        for (int i = 0; i < Socios.size(); i++) {
            System.out.println("Socio: " + Socios.get(i));
        }
    }

    public void mostrarLibro() {
        for (int i = 0; i < Libros.size(); i++) {
            System.out.println(Libros.get(i).toString('#'));
        }
    }

    public void mostrarPedidos() {
        for (int i = 0; i < Pedidos.size(); i++) {
            System.out.println("o---o---o---o---o---o---o---o---o---o---o");
            System.out.println(Pedidos.get(i));
            System.out.println("o---o---o---o---o---o---o---o---o---o---o");
        }
    }

    @Override
    public String toString() {
        return nombreFilial;
    }

    public  String toString(String barita){
        String socios="";

        for (int i=0;i<Socios.size();i++){
           socios= socios+barita+Socios.get(i).toString('#');
        }
        return socios;
    }
}
