package Utilita;

import Utilita.Utilita;
import Model.*;
import Menu.*;

import java.util.ArrayList;

public class UtilitaManutentore {

    private static final String INSERISCI_NOME_UNITA= "Inserisci il nome della nuova unità immobiliare";
    private static final String INSERISCI_TIPOLOGIA = "Inserisci la tipologia della nuova unità immobiliare";
    private static final String AVVERTIMENTO_CREAZIONE_UNITA = "Devi inserire almeno una stanza o un artefatto";
    private static final String SCELTA_ERRATA = "Scelta errara";
    private static final String AGGIUNTA_NUOVO_COMPONENTE = "Vuoi aggiungere un nuovo componente?";
    private static final String NESSUNA_UNITA_PRESENTE = "Al momento non sono presenti unità immobiliari nel sistema";
    private static final String SELEZIONA_UNITA_ELIMINABILE = "Al momento non sono presenti unità immobiliari nel sistema";
    private static final String RIMOZIONE_UNITA = "Unità rimossa con successo!";
    private static final String SCEGLI_UNITA = "Scegli quale unità immobiliare modificare";

    /**
     * Riceve in input il manutentore e si occupa di creare una unità immobiliare permettendo di aggiungere
     * almeno una stanza o un artefatto (e poi quanti se ne vogliono a scelta dell'utente
     **/
    public static void aggiungiUnitaImmobiliare(Manutentore manutentore) throws Exception {

        String nomeUnita = Utilita.nomeUnico(INSERISCI_NOME_UNITA, manutentore.getUnitaImmobiliari());

        String tipologia = Utilita.chiediStringa(INSERISCI_TIPOLOGIA);
        ArrayList<Stanza> stanze = new ArrayList<>();
        ArrayList<Artefatto> artefatti = new ArrayList<>();
        UnitaImmobiliare nuovaUnitaImmobiliare = new UnitaImmobiliare(nomeUnita, tipologia, stanze, artefatti);

        int scelta;
        Utilita.showText(AVVERTIMENTO_CREAZIONE_UNITA);
        do {
            scelta = Utilita.scelta("Model.Stanza", "Model.Artefatto");
            if (scelta == 1) {
                Stanza nuovaStanza = UtilitaUnitaImmobiliare.creaStanza(nuovaUnitaImmobiliare.getStanze());
                stanze.add(nuovaStanza);
                Utilita.showText(AGGIUNTA_NUOVO_COMPONENTE);
                scelta = Utilita.scelta("Si", "No");
            } else if (scelta == 2) {
                Artefatto nuovoArtefatto = UtilitaUnitaImmobiliare.creaArtefatto(nuovaUnitaImmobiliare.getArtefatti());
                artefatti.add(nuovoArtefatto);
                Utilita.showText(AGGIUNTA_NUOVO_COMPONENTE);
                scelta = Utilita.scelta("Si", "No");
            } else {
                Utilita.showText(SCELTA_ERRATA);
                Utilita.showText(AVVERTIMENTO_CREAZIONE_UNITA);
            }
        } while ((scelta == 1) || ((stanze.size() == 0) && (artefatti.size() == 0)));
        manutentore.addUnitaImmobiliare(nuovaUnitaImmobiliare);
    }

    public static void modificaUnitaImmobiliare(Manutentore manutentore) throws Exception {

        if (manutentore.getUnitaImmobiliari().isEmpty()) {
            Utilita.showText(NESSUNA_UNITA_PRESENTE);
        } else {
            Utilita.mostraLista(manutentore.getUnitaImmobiliari());
            int sceltaUnita = Utilita.chiediIntero(SCEGLI_UNITA);
            UnitaImmobiliare unitModify = manutentore.getUnitaImmobiliari().get(sceltaUnita-1);
            manutentore.modifyUnitaImmobiliare(unitModify);
        }
    }

    public static void rimuoviUnitaImmobiliare(Manutentore manutentore) throws Exception {

        if (manutentore.getUnitaImmobiliari().isEmpty()) {
            Utilita.showText(NESSUNA_UNITA_PRESENTE);
        } else {
            Utilita.mostraLista(manutentore.getUnitaImmobiliari());
            int sceltaUnita = Utilita.scelta(SELEZIONA_UNITA_ELIMINABILE);
            UnitaImmobiliare unitaDaRimuovere = manutentore.getUnitaImmobiliari().get(sceltaUnita-1);
            manutentore.removeUnitaImmobiliare(unitaDaRimuovere);
            Utilita.showText(RIMOZIONE_UNITA);
        }
    }
}