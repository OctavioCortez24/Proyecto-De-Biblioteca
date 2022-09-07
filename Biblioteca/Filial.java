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

    public void devolverLibro(int l) {
        Libros.get(l).setDisponibilidad(true);
    }

    public void anadirSocio(Socio s) {
        boolean bandera = false;
        for (int i = 0; i < Socios.size(); i++) {
            if (s.equals(Socios.get(i))) {
                bandera = true;
            }
        }

        if (!bandera) {
            Socios.add(s);
        } else {
            System.out.println("El socio que ingreso ya se encuentra añadido");
        }

    }

    public void anadirPedido(Pedido p) {
        Pedidos.add(p);
    }

    public void borrarLibro(int numeroLibro) {
        try {
            Libros.remove(Libros.get(numeroLibro));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("No existe un libro que tenga asignado ese numero");
        }

    }

    public void borrarSocio(int socio) {
        try {
            Socios.remove(Socios.get(socio));
            System.out.println("Socio borrado con exito");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("No existe un socio que tenga asignado ese numero");
        }
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

    public String toString(String barita, String elecion) {
        String string = "";

        if (elecion.equals("Socios")) {
            for (int i = 0; i < Socios.size(); i++) {
                string = string + Socios.get(i).toString("#") + barita;
            }
        } else if (elecion.equals("Libros")) {
            for (int i = 0; i < Libros.size(); i++) {
                string = string + Libros.get(i).toString("#") + barita;
            }
        } else if (elecion.equals("Pedidos")) {
            for (int i = 0; i < Pedidos.size(); i++) {
                string = string + Pedidos.get(i).toString("#") + barita;
            }
        }

        return string;
    }


}
