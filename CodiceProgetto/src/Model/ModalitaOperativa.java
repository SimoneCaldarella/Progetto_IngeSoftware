package Model;

import java.io.Serializable;

public class ModalitaOperativa implements Serializable{

    private String nome;
    private boolean parametrica;
    private int valore;

    public ModalitaOperativa(String name, boolean parametrica) {
        this.nome = name;
        this.parametrica = false; //Nella prima versione non esistono modalità parametriche
        //this.valore = value;
    }

    public int getValore() {
        return valore;
    }

    public String getNome() {
        return nome;
    }

    public boolean setValore(int valore) {
        if (parametrica) {
            this.valore = valore;
            return true;
        } else {
            return false;
        }
    }
}
