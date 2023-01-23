package Menus;
import Enum.Vacinas;

public class MenuVacina {

    public static void menuVacina() {
        System.out.println("Vacina desejada: ");
        System.out.println("[1] " + Vacinas.VACINA_1);
        System.out.println("[2] " + Vacinas.VACINA_2);
        System.out.println("[3] " + Vacinas.VACINA_3);
        System.out.println("[4] " + Vacinas.VACINA_4);
        System.out.println("[5] " + Vacinas.VACINA_5);
        System.out.println("[6] " + Vacinas.VACINA_6);
        System.out.println("[7] " + Vacinas.VACINA_7);
        System.out.println("[0] Retornar");
    }
    public static String escolhaVacina(int escolha){
        switch (escolha){
            case(1):{
                return String.valueOf(Vacinas.VACINA_1);
            }
            case(2):{
                return String.valueOf(Vacinas.VACINA_2);
            }
            case(3):{
                return String.valueOf(Vacinas.VACINA_3);
            }
            case(4):{
                return String.valueOf(Vacinas.VACINA_4);
            }
            case(5):{
                return String.valueOf(Vacinas.VACINA_5);
            }
            case(6):{
                return String.valueOf(Vacinas.VACINA_6);
            }
            case(7):{
                return String.valueOf(Vacinas.VACINA_7);
            }
        }
        return "";
    }
}