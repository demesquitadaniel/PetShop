package Menus;
import Enum.Higiene;

public class MenuHigienizar {

    public static void menuHigienizar() {
        System.out.println("Tipo de higienização desejada: ");
        System.out.println("[1] " + Higiene.BANHO);
        System.out.println("[2] " + Higiene.BANHO_TOSA);
        System.out.println("[3] " + Higiene.TOSA);
        System.out.println("[0] Retornar");
    }
    public static String escolhaHigienizar(int escolha){
        switch (escolha){
            case(1):{
                return String.valueOf(Higiene.BANHO);
            }
            case(2):{
                return String.valueOf(Higiene.TOSA);
            }
            case(3):{
                return String.valueOf(Higiene.BANHO_TOSA);
            }
        }
        return "";
    }
}