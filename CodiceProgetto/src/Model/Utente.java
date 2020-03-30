package Model;

import java.util.ArrayList;

public abstract class Utente {
    private String name;
    private int tipo;
    private ArrayList<UnitaImmobiliare> unitaImmobiliari;

    public String getNome() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getTipo() {
        return tipo;
    }
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public boolean setUnitaImmobiliari(ArrayList<UnitaImmobiliare> unitaImmobiliari) {
        this.unitaImmobiliari = unitaImmobiliari;
        return true;
    }

    public ArrayList<UnitaImmobiliare> getUnitaImmobiliari() {
        return unitaImmobiliari;
    }
}
