package Modelos;

import Enum.EstadoAnimal;
import Enum.Porte;

import java.util.Date;
import java.util.List;

public abstract class Animais {
    String nome;
    Date nascimento;
    String raca;
    Porte porte;
    Double peso;
    EstadoAnimal estadoanimal;
    List<EsquemaVacinal> vacinas;
    String observacao;

    public String getObservacao() {
    }

    public boolean getNome() {
        return false;
    }

    public Object getVacinas() {
    }

    public Object getEstadoanimal() {
    }

    public void setEstadoanimal(EstadoAnimal limpo) {
    }

    public void setObservacao(String observacaoout) {
    }

    public void setVacinas(EsquemaVacinal vacina) {
    }
}