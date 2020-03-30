package Menu;

import Model.*;
import Utilita.*;

import java.util.ArrayList;

public class Sistema {

    private static ArrayList<UnitaImmobiliare> unitaImmobiliari;
    private static Utente utente;
    public final static int maxNumeroUnita = 1; //Nella prima versione può esserci al massimo un'unità immobiliare
    private static boolean ciclo;
    private static final String MESSAGGIO_BENVENUTO = "Benvenuto nel sistema domotico!";
    private static final String INFO = "Nessuna unità immobiliare già presente nel sistema";

    public static void main(String[] args) throws Exception {

        unitaImmobiliari = UtilitaSistema.caricaDati();
        Utilita.showText(MESSAGGIO_BENVENUTO);
        if (unitaImmobiliari.size() == 0) {
            Utilita.showText(INFO);
            unitaImmobiliari = new ArrayList<>();
        }

        utente = UtilitaUtente.creaUtente(unitaImmobiliari);

        ciclo = true;
        do {
            if (utente.getTipo() == 0) { ciclo = MenuUtente.menuPrincipaleManutentore((Manutentore) utente); }
            else if (utente.getTipo() == 1) { ciclo = MenuUtente.menuPrincipaleFruitore((Fruitore) utente); }
        } while (ciclo);

        UtilitaSistema.esciDalSistema(unitaImmobiliari);

    }

}