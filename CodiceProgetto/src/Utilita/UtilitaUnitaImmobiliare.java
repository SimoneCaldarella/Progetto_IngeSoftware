package Utilita;

import Utilita.Utilita;
import Model.*;
import Menu.*;

import java.util.ArrayList;

public class UtilitaUnitaImmobiliare {

    private static final String INSERISCI_NOME_STANZA = "Inserisci il nome della stanza";
    private static final String INSERISCI_NOME_ARTEFATTO ="Inserisci il nome dell'artefatto";
    private static final String STANZA_DA_RIMUOVERE = "Scegli una stanza da rimuovere";
    private static final String STANZA_RIMOSSA = "Model.Stanza rimossa con successo";
    private static final String STANZA_DA_MODIFICARE = "Scegli una stanza da modificare";
    private static final String VISUALIZZA_DATI_STANZA = "Scegli una stanza di cui visualizzare i dati";
    private static final String VISUALIZZA_DATI_ARTEFATTO = "Scegli un artefatto di cui visualizzare i dati";
    private static final String ARTEFATTI = "Lista artefatti";
    private static final String DEVICES = "Lista devices";
    private static final String ARTEFATTO_DA_RIMUOVERE = "Scegli un artefatto da rimuovere";
    private static final String ARTEFATTO_RIMOSSO = "Model.Artefatto rimosso con successo";
    private static final String ARTEFATTO_DA_MODIFICARE = "Scegli un artefatto da modificare";

    //Funzioni sulle stanze
    public static Stanza creaStanza(ArrayList<Stanza> stanze) throws Exception {
        String nomeStanza = Utilita.nomeUnico(INSERISCI_NOME_STANZA, stanze);
        return new Stanza(nomeStanza);
    }

    public static void rimuoviStanza(ArrayList<Stanza> stanze) throws Exception {
        Utilita.mostraLista(stanze);
        if (!stanze.isEmpty()) {
            int scelta = Utilita.chiediIntero(STANZA_DA_RIMUOVERE);
            Stanza stanzaDaRimuovere = stanze.get(scelta - 1);
            stanze.remove(stanzaDaRimuovere);
            Utilita.showText(STANZA_RIMOSSA);
        }
    }

    public static void modificaStanza(ArrayList<Stanza> stanze) throws Exception {
        Utilita.mostraLista(stanze);
        if (!stanze.isEmpty()) {
            int scelta = Utilita.chiediIntero(STANZA_DA_MODIFICARE);
            Stanza stanzaDaModificare = stanze.get(scelta - 1);
            boolean ciclo;
            do {
                ciclo = MenuUnitaImmobiliare.menuModificaStanza(stanzaDaModificare);
            } while (ciclo);
        }

    }

    public static void visualizzaDatiStanza(ArrayList<Stanza> stanze) throws Exception {
        Utilita.mostraLista(stanze);
        if (!stanze.isEmpty()) {
            int scelta = Utilita.chiediIntero(VISUALIZZA_DATI_STANZA);
            Stanza stanza = stanze.get(scelta - 1);
            Utilita.showText("Nome stanza: " + stanza.getNome());
            Utilita.showText(ARTEFATTI);
            Utilita.mostraLista(stanza.getArtefatti());
            Utilita.showText(DEVICES);
            Utilita.mostraLista(stanza.getDevices());
        }
    }

    //Funzioni sugli artefatti
    public static Artefatto creaArtefatto(ArrayList<Artefatto> artefatti) throws Exception {
        String nomeArtefatto = Utilita.nomeUnico(INSERISCI_NOME_ARTEFATTO, artefatti);
        return new Artefatto(nomeArtefatto);
    }

    public static void visualizzaDatiArtefatto(ArrayList<Artefatto> artefatti) throws Exception {
        Utilita.mostraLista(artefatti);
        if (!artefatti.isEmpty()) {
            int scelta = Utilita.chiediIntero(VISUALIZZA_DATI_ARTEFATTO);
            Artefatto artefatto = artefatti.get(scelta - 1);
            Utilita.showText("Nome artefatto: " + artefatto.getNome());
            Utilita.showText(DEVICES);
            Utilita.mostraLista(artefatto.getDevices());
        }
    }

    public static void rimuoviArtefatto(ArrayList<Artefatto> artefatti) throws Exception {
        Utilita.mostraLista(artefatti);
        if (!artefatti.isEmpty()) {
            int scelta = Utilita.chiediIntero(ARTEFATTO_DA_RIMUOVERE);
            Artefatto artefattoDaRimuovere = artefatti.get(scelta - 1);
            artefatti.remove(artefattoDaRimuovere);
            Utilita.showText(ARTEFATTO_RIMOSSO);
        }
    }

    public static void modificaArtefatto(ArrayList<Artefatto> artefatti) throws Exception {
        Utilita.mostraLista(artefatti);
        if (!artefatti.isEmpty()) {
            int scelta = Utilita.chiediIntero(ARTEFATTO_DA_MODIFICARE);
            Artefatto artefatto = artefatti.get(scelta - 1);
            boolean ciclo;
            do {
                ciclo = MenuUnitaImmobiliare.menuModificaArtefatto(artefatto);
            } while (ciclo);
        }
    }
}
