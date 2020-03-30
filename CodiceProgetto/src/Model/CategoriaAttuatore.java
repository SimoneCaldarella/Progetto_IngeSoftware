package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class CategoriaAttuatore implements Serializable {

    private String nome;
    private String descrizione;
    private ArrayList<ModalitaOperativa> modalitaOperative;

    public CategoriaAttuatore(String nome, String descrizione) {
        this.nome = nome;
        this.descrizione = descrizione;
        modalitaOperative = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public ArrayList<ModalitaOperativa> getModalitaOperative() {
        return modalitaOperative;
    }

    public void addModalita(ModalitaOperativa modalitaOperativa) {
        modalitaOperative.add(modalitaOperativa);
    }

    public void removeModalita(ModalitaOperativa modalitaOperativa) {
        modalitaOperative.remove(modalitaOperativa);
    }

}