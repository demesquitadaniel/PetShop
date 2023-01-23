package Util;

import java.util.Scanner;

public class LerTeclado {
    public static int lerTeclado() {
        Scanner scan = new Scanner(System.in);
        int numero;
        try {
            numero = scan.nextInt();
            if(numero >= 0) {
                return numero;
            }else{
                System.out.println("Número Inválido. Verifique a numeração e tente novamente: ");
                throw new RuntimeException();
            }
        }catch (RuntimeException e){

            return lerTeclado();
        }
    }

    public static void pausa() {
        System.out.println("\nAperte 'Enter' para prosseguir");
        Scanner scan = new Scanner(System.in);
        scan.nextLine();

    }
}