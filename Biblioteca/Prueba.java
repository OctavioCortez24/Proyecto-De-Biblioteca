package Biblioteca;
import java.util.*;
public class Prueba {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int num1 = 0, num2 = 0;
        boolean cacatua = false;
        System.out.print("Introduzca dos valores: ");
        do {

            try {
                num1 = entrada.nextInt();
                num2 = entrada.nextInt();
                cacatua = true;
            } catch (Exception e) {
                System.out.println("Incorrecto, introduzca dos valores: ");
                cacatua = false;
            }
        } while (cacatua == false);
        {
            System.out.println("La suma es " + (num1 + num2));
            entrada.close();
        }

    }
}
