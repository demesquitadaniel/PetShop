import Enum.EstadoAnimal;
import Enum.Higiene;
import Enum.Porte;
import Enum.Vacinas;
import Modelos.Cachorro;
import Modelos.Cliente;
import Modelos.Gato;
import Modelos.ResponseVO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static Util.LerTeclado.pausa;


public class Main {
    public static void main(String[] args) {

        System.out.println("Cliente #1");
        List<Integer> itens1 = new ArrayList<Integer>();
        List<Integer> itens2 = new ArrayList<Integer>();
        PetShop petshop = new PetShop("88855599/0001-01");
        Cliente cliente1 = new Cliente(1001,"Alice");
        Cliente cliente2 = new Cliente(1002, "Maria Donária");


        ResponseVO cliente1response = new ResponseVO();
        ResponseVO cliente2response = new ResponseVO();

        Cachorro cachorro1 = new Cachorro("Rex", LocalDate.of(2020,01,02),"Pastor Alemão",Porte.MEDIO,5.0,EstadoAnimal.SUJO,"" );
        Cachorro cachorro2 = new Cachorro("Brutus",LocalDate.of(2014,01,30), "Golden Retriever", Porte.GRANDE, 25.0, EstadoAnimal.SUJO,"");
        Gato gato1 = new Gato("Tepo",LocalDate.of(2018,12,15), "Siames", Porte.PEQUENO, 4.0, EstadoAnimal.SUJO,"");

        cliente1.addPets(cachorro1);
        cliente2.addPets(cachorro2);
        cliente2.addPets(gato1);


        cliente1response = petshop.atendimentoClinico(cliente1, cliente1.getPets(), "Verificar as necessidades do pet");
        for (int i = 0; i < cliente1.getPets().size(); i++) {
            itens1.add(cliente1response.getId());
        }
        System.out.println(cliente1response.toString());

        List<Vacinas> vacinascliente1 = new ArrayList<Vacinas>();
        for (int petnumero = 0; petnumero < cliente1.getPets().size(); petnumero++){
            String vacina = cliente1.getPets().get(petnumero).getObservacao();
            vacinascliente1.add(converteVacina(vacina));
        }
        cliente1response = petshop.vacinacao(cliente1, cliente1.getPets(),vacinascliente1,"Aplicar vacina");
        for (int i = 0; i < cliente1.getPets().size(); i++) {
            itens1.add(cliente1response.getId());
        }
        System.out.println(cliente1.getPets().get(0).getNome() + " " + cliente1.getPets().get(0).getVacinas().toString());
        System.out.println(cliente1response.toString());

        cliente1response = petshop.higienizar(cliente1, cliente1.getPets(), Higiene.BANHO_TOSA, "Animal apresenta infecção nas patas");
        for (int i = 0; i < cliente1.getPets().size(); i++) {
            itens1.add(cliente1response.getId());
        }
        System.out.println(cliente1.getPets().get(0).getNome() + " está " + cliente1.getPets().get(0).getEstadoanimal());
        System.out.println(cliente1response.toString());

        petshop.veralimentos();
        petshop.verremedios();

        pausa();
        itens1.add(2001);

        itens1.add(3004);

        System.out.println(cliente1response.toString());
        petshop.pagamento(itens1);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        pausa();
        System.out.println("\n%%%%%%%%%%%%%%%%%%%%%%%%\n\nCliente #2");

        cliente2response = petshop.atendimentoClinico(cliente2,cliente2.getPets(), "Um gato e um cachorro");
        for (int i = 0; i < cliente2.getPets().size(); i++) {
            itens2.add(cliente2response.getId());
        }


        System.out.println(cliente2response.toString());
        List<Vacinas> vacinascliente2 = new ArrayList<Vacinas>();
        for (int petnumero = 0; petnumero < cliente2.getPets().size(); petnumero++){
            String vacina = cliente2.getPets().get(petnumero).getObservacao();
            vacinascliente2.add(converteVacina(vacina));
        }
        cliente2response = petshop.vacinacao(cliente2, cliente2.getPets(),vacinascliente2,"Aplicar vacina");
        for (int i = 0; i < cliente2.getPets().size(); i++) {
            itens2.add(cliente2response.getId());
        }

        System.out.println(cliente2.getPets().get(0).getNome() + " " + cliente2.getPets().get(0).getVacinas().toString());
        System.out.println(cliente2.getPets().get(1).getNome() + " " + cliente2.getPets().get(1).getVacinas().toString());
        System.out.println(cliente2response.toString());

        cliente2response = petshop.higienizar(cliente2, cliente2.getPets(), Higiene.BANHO, "Cuidado com as orelhas");
        for (int i = 0; i < cliente2.getPets().size(); i++) {
            itens2.add(cliente2response.getId());
        }
        System.out.println(cliente2.getPets().get(0).getNome() + " está " + cliente2.getPets().get(0).getEstadoanimal());
        System.out.println(cliente2.getPets().get(1).getNome() + " está " + cliente2.getPets().get(1).getEstadoanimal());
        System.out.println(cliente2response.toString());

        petshop.veralimentos();
        petshop.verremedios();

        itens2.add(2002);
        itens2.add(2005);
        itens2.add(3002);
        itens2.add(3005);

        pausa();

        System.out.println(cliente2response.toString());
        petshop.pagamento(itens2);

    }


    public static Vacinas converteVacina(String vacina){
        Vacinas vacinacliente = null;

        if(vacina == Vacinas.VACINA_1.name()) {
            vacinacliente = Vacinas.VACINA_1;
        }
        if(vacina == Vacinas.VACINA_2.name()) {
            vacinacliente = Vacinas.VACINA_2;
        }
        if(vacina == Vacinas.VACINA_3.name()) {
            vacinacliente = Vacinas.VACINA_3;
        }
        if(vacina == Vacinas.VACINA_4.name()) {
            vacinacliente = Vacinas.VACINA_4;
        }
        if(vacina == Vacinas.VACINA_5.name()){
            vacinacliente = Vacinas.VACINA_5;
        }
        if(vacina == Vacinas.VACINA_6.name()){
            vacinacliente = Vacinas.VACINA_6;
        }
        if(vacina == Vacinas.VACINA_7.name()){
            vacinacliente = Vacinas.VACINA_7;
        }
        return vacinacliente;
    }
}