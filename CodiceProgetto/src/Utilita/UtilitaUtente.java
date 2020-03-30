package Utilita;

import Utilita.Utilita;
import Model.*;
import Menu.*;

import java.util.ArrayList;

public class UtilitaUtente {

    private static final String MANUTENTORE = "Manutentore";
    private static final String FRUITORE = "Fruitore";
    private static final String CHIEDI_NOME = "Inserisci il tuo nome";
    private static final String CHIEDI_TIPO = "Inserisci il tipo di utente";
    private static final String SCELTA_UNITA = "Seleziona l'unità di cui vorresti visualizzare i dati";

    public static Utente creaUtente(ArrayList<UnitaImmobiliare> unitaImmobiliari) {
        Utilita.showText(CHIEDI_TIPO);
        int scelta = Utilita.scelta(MANUTENTORE,FRUITORE);

        String nome = Utilita.chiediStringa(CHIEDI_NOME);
        if (scelta == 1) {
            Manutentore utente = creaManutentore(nome, unitaImmobiliari);
            return utente;
        }
        else {
            Fruitore utente = creaFruitore(nome, unitaImmobiliari);
            return utente;
        }
    }

    public static Manutentore creaManutentore(String nome, ArrayList<UnitaImmobiliare> unitaImmobiliari){
        Manutentore manutentore = new Manutentore(nome, unitaImmobiliari);
        return manutentore;
    }

    public static Fruitore creaFruitore(String nome, ArrayList<UnitaImmobiliare> unitaImmobiliari){
        Fruitore fruitore = new Fruitore(nome, unitaImmobiliari);
        return fruitore;
    }

    public static void visualizzaDatiUI(Utente utente) throws Exception {
        Utilita.mostraLista(utente.getUnitaImmobiliari());
        if (!utente.getUnitaImmobiliari().isEmpty()) {
            int sceltaUnita = Utilita.chiediIntero(SCELTA_UNITA);
            UnitaImmobiliare unita = utente.getUnitaImmobiliari().get(sceltaUnita - 1);
            boolean ciclo;
            do {
                ciclo = MenuUtente.menuVisualizzaDatiUnita(unita);
            } while (ciclo);
        }
    }

}