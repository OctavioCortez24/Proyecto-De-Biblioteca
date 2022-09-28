package Biblioteca;

import com.mysql.cj.conf.PropertyDefinitions;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class Libro {
    private String tituloDeLib;
    private boolean disponibilidad;
    private String nombreDelAutor;
    private String categoria;
    private int libroID;
    private boolean desactivado;


    public Libro() {

    }

    public Libro(int idLibro,String nombre, String nombreDelAutor, String categoria, boolean disponibilidad, boolean desactivado) {
        this.libroID=idLibro;
        this.tituloDeLib = nombre;
        this.nombreDelAutor = nombreDelAutor;
        this.categoria = categoria;
        this.disponibilidad = disponibilidad;
        this.desactivado=desactivado;
    }

    public String getTituloDeLib() {
        return tituloDeLib;
    }

    public void setTituloDeLib(String tituloDeLib) {
        this.tituloDeLib = tituloDeLib;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getNombreDelAutor() {
        return nombreDelAutor;
    }

    public void setNombreDelAutor(String nombreDelAutor) {
        this.nombreDelAutor = nombreDelAutor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getLibroID() {
        return libroID;
    }

    public void setLibroID(int libroID) {
        this.libroID = libroID;
    }

    public boolean isDesactivado() {
        return desactivado;
    }

    public void setDesactivado(boolean desactivado) {
        this.desactivado = desactivado;
    }

    @Override
    public String toString() {
        String dispo = disponibilidad?"Disponible":"No Disponible";
        String desac= desactivado?"Si":"No";

        return "Titulo: " + tituloDeLib + "\n"
                + "Autor: " + nombreDelAutor + "\n"
                + "Categoria: " + categoria + "\n"
                + "Disponibilidad: " + dispo+"\n"+
                "Dado de baja: "+desac;
    }

    public String toString(String ceparador) {
        return tituloDeLib + ceparador + nombreDelAutor + ceparador + categoria + ceparador + disponibilidad;
    }

    @Override
    public boolean equals(Object obj) {
        Libro l= (Libro)obj;

        return tituloDeLib==l.tituloDeLib&nombreDelAutor==l.nombreDelAutor&categoria==l.categoria&disponibilidad==l.disponibilidad&desactivado== l.desactivado;
    }

    public void añadirLibro(){
        ArrayList<String> Libros = new ArrayList<>();
        Libros.addAll(GestorArchivos.cargarArray("ArrayLibros.txt"));
        Libros.add(libroID + "%" + tituloDeLib + "%" + nombreDelAutor + "%" + categoria + "%" + disponibilidad+"%"+desactivado);
        //Guardo el array de String con el metodo guardarArray del Gestor de Archivos
        GestorArchivos.guardarArray(Libros, "ArrayLibros.txt");
        try {
            PreparedStatement pSInsert = Conexion.getInstance().prepareStatement("INSERT INTO libros VALUES(?,?,?,?,?,?)");
            pSInsert.setString(1, null);
            pSInsert.setString(2, tituloDeLib);
            pSInsert.setString(3, nombreDelAutor);
            pSInsert.setString(4, categoria);
            pSInsert.setBoolean(5, disponibilidad);
            pSInsert.setBoolean(6,desactivado);
            pSInsert.executeUpdate();

            pSInsert.close();

        } catch (SQLException e) {
            System.out.println("Error en guardar un libro");
            throw new RuntimeException(e);
        }
    }

    public void darDeBaja(){

    }
    public boolean validacion(){
        ArrayList<Libro>LibrosC=Modelo.cargarArrayDeObjetoLibro();
        boolean retorno=false;
        for (int i=0;i<LibrosC.size();i++){
            if (equals(LibrosC.get(i))){
                retorno=true;
            }
        }
        return retorno;
    }
}
