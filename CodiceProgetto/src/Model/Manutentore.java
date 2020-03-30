package Model;

import java.util.ArrayList;
import Menu.*;

public class Manutentore extends Utente {

    public Manutentore(String name, ArrayList<UnitaImmobiliare> unitaImmobiliari) {
        setName(name);
        setTipo(0);
        setUnitaImmobiliari(unitaImmobiliari);
    }

    //Aggiungi e rimuovi categorie sensori e attuatori;

    public void addUnitaImmobiliare(UnitaImmobiliare unitaImmobiliare) {
        getUnitaImmobiliari().add(unitaImmobiliare);
    }

    public void modifyUnitaImmobiliare(UnitaImmobiliare unitaImmobiliare) throws Exception {
        boolean ciclo;
        do {
            ciclo = MenuUnitaImmobiliare.menuModificaUnitaImmobiliare(unitaImmobiliare);
        } while (ciclo);
    }

    public void removeUnitaImmobiliare(UnitaImmobiliare unitaImmobiliare) {
        getUnitaImmobiliari().remove(unitaImmobiliare);
    }
}
