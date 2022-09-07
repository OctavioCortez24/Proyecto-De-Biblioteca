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
        boolean bandera=false;
        for (int i=0;i<Socios.size();i++){
            if (Socios.get(i).equals(s)){
                bandera=true;
            }
        }
        if (!bandera){
            Socios.add(s);

        }

    }

    public void anadirPedido(Pedido p) {
        Pedidos.add(p);
    }

    public void borrarLibro(int numeroLibro) {
        Libros.remove(Libros.get(numeroLibro));
    }

    public void borrarSocio(int socio) {
        Socios.remove(Socios.get(socio));
    }

    public void mostrarSocio() {
        Vista.mostrarLosSocios(Socios);
    }

    public void mostrarLibro() {
        Vista.mostrarLosLibros(Libros);
    }

    public void mostrarPedidos() {
        Vista.mostraarLosPedidos(Pedidos);
    }

    @Override
    public String toString() {
        return nombreFilial;
    }

    public  String toStringSocios(String barita){
        String socios="";

        for (int i=0;i<Socios.size();i++){
           socios= socios+Socios.get(i).toString("#")+barita;
        }
        return socios;
    }
    public String toStringLibros(String barita){
        String libros="";

        for (int i=0;i<Libros.size();i++){
            libros= libros+Libros.get(i).toString("#")+barita;
        }
        return libros;
    }

}
