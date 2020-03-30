package Model;

import java.io.Serializable;

public class InformazioneRilevabile implements Serializable{

    private String nome;
    public InformazioneRilevabile(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

}

