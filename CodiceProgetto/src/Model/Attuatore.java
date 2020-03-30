package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Attuatore extends Device implements Serializable {

    private CategoriaAttuatore categoriaAttuatore;
    private ModalitaOperativa modalitaCorrente;

    public Attuatore(String nome, CategoriaAttuatore categoriaAttuatore) {
        setNome(nome+"_"+categoriaAttuatore.getNome());
        this.categoriaAttuatore = categoriaAttuatore;
        attiva(); //Nella prima versione tutti gli attuatori sono accesi
    }

    public String getDescrizione() {
        return categoriaAttuatore.getDescrizione();
    }

    public void setModalitaCorrente(ModalitaOperativa modalitaOperativa) {
        modalitaCorrente = modalitaOperativa;
    }

    public ModalitaOperativa getModalitaCorrente() {
        return modalitaCorrente;
    }

    public CategoriaAttuatore getCategoriaAttuatore() {
        return categoriaAttuatore;
    }

    public ArrayList<ModalitaOperativa> getModalitaOperative() {
        return categoriaAttuatore.getModalitaOperative();
    }

}