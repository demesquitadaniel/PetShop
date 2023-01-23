package Util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Util.Alimento.listaAlimento;
import static Util.Remedio.listaRemedio;

public class Produtos {
    protected int id;
    protected String nome;
    protected BigDecimal valor;

    public Produtos(int id, String nome, BigDecimal valor) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
    }

    public Produtos() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public static List<Produtos> criaProdutos() {
        List<Produtos> listaprodutos = new ArrayList<Produtos>();
        List<Produtos> listasercicos = new ArrayList<Produtos>();
        listasercicos = listaServicos();
        for (int i = 0; i < listasercicos.size(); i++) {
            listaprodutos.add(listasercicos.get(i));
        }
        List<Produtos> listaalimento = new ArrayList<Produtos>();
        listaalimento = listaAlimento();
        for (int i = 0; i < listaalimento.size(); i++) {
            listaprodutos.add(listaalimento.get(i));
        }
        List<Produtos> listaremedio = new ArrayList<Produtos>();
        listaremedio = listaRemedio();
        for (int i = 0; i < listaremedio.size(); i++) {
            listaprodutos.add(listaremedio.get(i));
        }

        return listaprodutos;
    }

    public static List<Produtos> listaServicos() {
        Produtos servico1 = new Produtos(1001,"Atendimento Clinico",BigDecimal.valueOf(50));
        Produtos servico2 = new Produtos(1101,"Vacinação",BigDecimal.valueOf(80));
        Produtos servico3 = new Produtos(1102,"Vacinação",BigDecimal.valueOf(80));
        Produtos servico4 = new Produtos(1103,"Vacinação",BigDecimal.valueOf(80));
        Produtos servico5 = new Produtos(1104,"Vacinação",BigDecimal.valueOf(80));
        Produtos servico6 = new Produtos(1105,"Vacinação",BigDecimal.valueOf(80));
        Produtos servico7 = new Produtos(1201,"Banho",BigDecimal.valueOf(40));
        Produtos servico8 = new Produtos(1202,"Tosa",BigDecimal.valueOf(30));
        Produtos servico9 = new Produtos(1203,"Banho e Tosa",BigDecimal.valueOf(60));

        return Arrays.asList(servico1,servico2,servico3,servico4,servico5,servico6,servico7,servico8,servico9);
    }
    public static void listaProdutos(List<Produtos> listaprodutos) {
        for (Produtos produto : listaprodutos) {
            System.out.println(produto.toString());
        }
    }
    @Override
    public String toString() {
        return "Serviços{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", valor=" + valor +
                '}';
    }
}