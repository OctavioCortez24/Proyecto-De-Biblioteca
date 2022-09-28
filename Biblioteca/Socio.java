package Biblioteca;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class Socio {

    private String nombre;
    private String apellido;
    private int DNI;
    private int socioID;
    private boolean desactivado;

    public Socio() {
    }

    public Socio(int socioID,String nombre, String apellido, int DNI, boolean desactivado) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
        this.socioID=socioID;
        this.desactivado=desactivado;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public boolean isDesactivado() {
        return desactivado;
    }

    public void setDesactivado(boolean desactivado) {
        this.desactivado = desactivado;
    }

    public int getSocioID() {
        return socioID;
    }

    public void setSocioID(int socioID) {
        this.socioID = socioID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return DNI;
    }

    public void setDni(int ID) {
        this.DNI = DNI;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + " " + DNI;
    }

    public String toString(String ceparador) {
        return nombre + ceparador + apellido + ceparador + DNI;
    }

    @Override
    public boolean equals(Object obj) {
        Socio s = (Socio) obj;
        return nombre.equals(s.nombre) & apellido.equals(s.apellido) & DNI==s.DNI;
    }
    public void agregarSocio(){
        //Para guardar en txt
        ArrayList<String> Socios = new ArrayList<>();
        Socios.addAll(GestorArchivos.cargarArray("ArraySocios.txt"));
        Socios.add(socioID + "%" + nombre + "%" + apellido + "%" + DNI);
        GestorArchivos.guardarArray(Socios, "ArraySocios.txt");
        //------
        try {
            PreparedStatement pSInsert = Conexion.getInstance().prepareStatement("INSERT INTO socios VALUES(?,?,?,?,?)");
            pSInsert.setString(1, null);
            pSInsert.setString(2, nombre);
            pSInsert.setString(3, apellido);
            pSInsert.setInt(4, DNI);
            pSInsert.setBoolean(5,desactivado);
            pSInsert.executeUpdate();


            pSInsert.close();

        } catch (SQLException e) {
            System.out.println("Error en guardar un socio");
            throw new RuntimeException(e);
        }
    }
    public void darDeBaja(){
        desactivado=true;

    }
    public boolean validacion(){
        ArrayList<Socio>SociosC=Modelo.cargarArrayDeObjetoSocio();
        boolean retorno=false;
        for (int i=0;i<SociosC.size();i++){
            if (equals(SociosC.get(i))){
                retorno=true;
            }
        }
        return retorno;
    }

}
