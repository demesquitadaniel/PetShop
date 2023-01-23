import Enum.EstadoAnimal;
import Enum.Higiene;
import Enum.Servicos;
import Enum.Vacinas;
import Modelos.*;
import Util.Produtos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static Menus.MenuAlimento.escolhaAlimento;
import static Menus.MenuAlimento.menuAlimento;
import static Menus.MenuAtendimento.menuAtendimento;
import static Menus.MenuRemedio.escolhaRemedio;
import static Menus.MenuRemedio.menuRemedio;
import static Menus.MenuVacina.escolhaVacina;
import static Menus.MenuVacina.menuVacina;
import static Util.Alimento.listaAlimento;
import static Util.LerTeclado.lerTeclado;
import static Util.LerTeclado.pausa;
import static Util.Produtos.criaProdutos;
import static Util.Remedio.listaRemedio;

public class PetShop {
    String cnpj;
    Endereco endereco;

    public PetShop(String cnpj) {
        this.cnpj = cnpj;

    }

    ResponseVO higienizar (Cliente cliente, List<Animais> animais, Higiene higiene, String observacao) {

        ResponseVO responseVO = new ResponseVO();
        responseVO.setCliente(cliente);
        for (int numeroatendimento = 0; numeroatendimento < animais.size(); numeroatendimento++) {
            System.out.println(animais.get(numeroatendimento).getNome() + " está se higienizando, ele está " + animais.get(numeroatendimento).getEstadoanimal() );
            pausa();
            responseVO.setServico(Servicos.HIGIENIZACAO);
            if (higiene == Higiene.BANHO) {
                responseVO.setId(1201);
                responseVO.setValor(BigDecimal.valueOf(40));
                animais.get(numeroatendimento).setEstadoanimal(EstadoAnimal.LIMPO);
            }
            if (higiene == Higiene.TOSA) {
                responseVO.setId(1202);
                responseVO.setValor(BigDecimal.valueOf(30));
                animais.get(numeroatendimento).setEstadoanimal(EstadoAnimal.TOSADO);
            }
            if (higiene == Higiene.BANHO_TOSA) {
                responseVO.setId(1203);
                responseVO.setValor(BigDecimal.valueOf(60));
                animais.get(numeroatendimento).setEstadoanimal(EstadoAnimal.LIMPO_TOSADO);
            }
        }
        return responseVO;
    }
    ResponseVO atendimentoClinico (Cliente cliente, List<Animais> animais, String observacao) {
        ResponseVO responseVO = new ResponseVO();
        responseVO.setCliente(cliente);
        String observacaoin = observacao;
        responseVO.setId(1001);
        responseVO.setValor(BigDecimal.valueOf(50));
        responseVO.setServico(Servicos.ATENDIMENTO);
        for (int numeroatendimento = 0; numeroatendimento < animais.size(); numeroatendimento++) {
            String observacaoout;
            System.out.println(animais.get(numeroatendimento).getNome() + " está em atendimento");
            int retorno;
            int escolha;
            while (true) {
                while (true) {
                    menuAtendimento();
                    retorno = lerTeclado();
                    if (retorno > 3) {
                        System.out.println("Opção inválida.  Tente novamente: ");
                    } else {
                        break;
                    }
                }
                switch (retorno) {
                    case (0): {
                        System.out.println("O pet está bem.");
                        break;
                    }
                    case (1): {
                        while (true) {
                            menuVacina();
                            escolha = lerTeclado();
                            if (escolha > Vacinas.values().length) {
                                System.out.println("Opção inválida, tente novamente: ");
                                continue;
                            }
                            break;
                        }
                        if (escolha == 0) {
                            continue;
                        }
                        observacaoout = escolhaVacina(escolha);
                        System.out.println(observacaoout);
                        animais.get(numeroatendimento).setObservacao(observacaoout);
                        break;
                    }
                    case (2): {
                        List<Produtos> lista = new ArrayList<Produtos>();
                        lista = listaRemedio();
                        while (true) {
                            menuRemedio();
                            escolha = lerTeclado();
                            if (escolha > lista.size()) {
                                System.out.println("Medicação inválida. Tente novamente: ");
                                continue;
                            }
                            break;
                        }
                        if (escolha == 0) {
                            continue;
                        }
                        observacaoout = escolhaRemedio(escolha);
                        System.out.println(observacaoout);
                        animais.get(numeroatendimento).setObservacao(observacaoout);
                        break;
                    }
                    case (3): {
                        List<Produtos> lista = new ArrayList<Produtos>();
                        lista = listaAlimento();
                        while (true) {
                            menuAlimento();
                            escolha = lerTeclado();
                            if (escolha > lista.size()) {
                                System.out.println("Produto inválido. Tente novamente: ");
                                continue;
                            }
                            break;
                        }
                        if (escolha == 0) {
                            continue;
                        }
                        observacaoout = escolhaAlimento(escolha);
                        System.out.println(observacaoout);
                        animais.get(numeroatendimento).setObservacao(observacaoout);
                        break;
                    }
                }break;
            }
        }
        return responseVO;
    }


    ResponseVO vacinacao (Cliente cliente, List<Animais> animais, List<Vacinas> vacinas, String observacao){
        ResponseVO responseVO = new ResponseVO();
        responseVO.setCliente(cliente);
        for (int numeroatendimento = 0; numeroatendimento < animais.size(); numeroatendimento ++ ) {
            responseVO.setId(1101+vacinas.get(numeroatendimento).ordinal());
            responseVO.setValor(BigDecimal.valueOf(80));
            responseVO.setServico(Servicos.VACINACAO);
            System.out.println("Pet em atendimento "+animais.get(numeroatendimento).getNome());
            EsquemaVacinal vacina = new EsquemaVacinal(vacinas.get(numeroatendimento), LocalDate.now(),"Vacinado");
            cliente.getPets().get(numeroatendimento).setVacinas(vacina);
        }
        return responseVO;
    }

    void veralimentos(){
        List<Produtos> listaalimento = new ArrayList<Produtos>();
        listaalimento = listaAlimento();
        for (Produtos alimentos:listaalimento) {
            System.out.println(alimentos.toString());
        }
    }

    void verremedios(){
        List<Produtos> listaremedio = new ArrayList<Produtos>();
        listaremedio = listaRemedio();
        for (Produtos remedio:listaremedio) {
            System.out.println(remedio.toString());
        }
    }
    ResponseVO comprar(Cliente cliente){
        ResponseVO responseVO = new ResponseVO();
        int escolha;
        responseVO.setCliente(cliente);
        List<Produtos> listacompra = new ArrayList<Produtos>();
        List<Produtos> listaremedio = new ArrayList<Produtos>();
        listaremedio = listaRemedio();
        List<Produtos> listaalimento = new ArrayList<Produtos>();
        listaalimento = listaAlimento();
        for (int i = 0; i < listaremedio.size(); i++) {
            listacompra.add(listaremedio.get(i));
        }
        for (int i = 0; i < listaalimento.size(); i++) {
            listacompra.add(listaalimento.get(i));
        }

        while(true) {

            while (true) {
                System.out.println("Escolha o produto desejado: ");
                for (int i = 0; i < listacompra.size(); i++) {
                    System.out.println((i + 1) + " " + listacompra.get(i).getNome() + " " + listacompra.get(i).getValor());
                }
                System.out.println("Digite '0' para finalizar.");
                escolha = lerTeclado();
                if (escolha > listacompra.size()) {
                    System.out.println("Produto inválido. Tente novamente: ");
                    continue;
                }
                break;
            }
            if (escolha == 0) {
                System.out.println("Compra efetuada com sucesso!");
                System.out.println(responseVO.toString());
                break;
            }
            escolha--;
            responseVO.setId(listacompra.get(escolha).getId());
            responseVO.setValor(listacompra.get(escolha).getValor());
            System.out.println(listacompra.get(escolha).getNome() + " adicionado com sucesso.");
        } return responseVO;
    }
    void pagamento(List<Integer> itens){
        BigDecimal total = BigDecimal.ZERO;
        List<Produtos> listaprodutos = new ArrayList<Produtos>();
        listaprodutos = criaProdutos();
        System.out.println("Nota Fiscal");
        for(int i = 0; i < itens.size(); i++){
            for(int j = 0; j < listaprodutos.size(); j++) {
                if(itens.get(i) == listaprodutos.get(j).getId()) {
                    total = listaprodutos.get(j).getValor().add(total);
                    System.out.println((i+1)+" "+listaprodutos.get(j).getNome() + " " + listaprodutos.get(j).getValor() + "R$");
                }
            }
        }
        System.out.println("O tatal foi de R$ " + total);
    }
}