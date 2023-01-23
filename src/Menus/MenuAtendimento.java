package Menus;

public class MenuAtendimento {
    public static void menuAtendimento(){

        System.out.println("Tipo de atendimento desejado: ");
        System.out.println("[1] Produtos");
        System.out.println("[2] Remédio");
        System.out.println("[3] Vacina");
        System.out.println("[0] Retornar");
    }
    public static String escolhaAtendimento(int escolha){
        switch (escolha){
            case(1):{
                return "Produtos";
            }
            case(2):{
                return "Remédio";
            }
            case(3):{
                return "Vacina";
            }
        }
        return "";
    }
}