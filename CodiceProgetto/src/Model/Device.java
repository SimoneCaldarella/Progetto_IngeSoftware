package Model;

import Model.Artefatto;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Device implements Serializable {

    private String nome;
    private ArrayList<Stanza> stanze;
    private ArrayList<Artefatto> artefatti;
    private boolean stato;

    public void attiva() {
        stato = true;
    }

    public void disattiva() {
        stato = false;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public abstract String getDescrizione();

    public boolean addStanza(Stanza stanza) {
        stanze.add(stanza);
        return true;
    }

    public boolean addArtefatto(Artefatto artefatto) {
        artefatti.add(artefatto);
        return true;
    }

}
