package Biblioteca;
import  java.util.*;
public class CUENTA {
    public static void main(String[] args) {
        Scanner LeerNumero=new Scanner(System.in);
        System.out.println("Ingrese el divisor:");
        int divisor= LeerNumero.nextInt();
        System.out.println("ingrese el dividendo:");
        int dividendo=LeerNumero.nextInt();
        int resultado=dividendo/divisor;
        int cociente=dividendo%divisor;
        System.out.println("Resultado: "+resultado);
        System.out.println("Cociente: "+cociente);
    }
}
