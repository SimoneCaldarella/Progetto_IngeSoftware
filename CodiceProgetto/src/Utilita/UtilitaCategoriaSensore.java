package Utilita;

import Model.*;
import Menu.*;

public class UtilitaCategoriaSensore {

    private static final String INSERISCI_NOME_INFORMAZIONE = "Inserisci il nome dell'informazione da aggiungere";
    private static final String INSERISCI_INFORMAZIONE_RIMOVIBILE = "Inserisci il nome dell'informazione da rimuovere";
    private static final String DESCRIZIONE_ATTUALE = "Descrizione attuale:";
    private static final String INSERISCI_DESCRIZIONE = "Inserisci la nuova descrizione";

    public static void aggiungiInformazione(CategoriaSensore categoriaSensore) throws Exception {
        String nome = Utilita.nomeUnico(INSERISCI_NOME_INFORMAZIONE, categoriaSensore.getInformazioniRilevabili());
        categoriaSensore.addInformazione(new InformazioneRilevabile(nome));
    }

    public static void rimuoviInformazione(CategoriaSensore categoriaSensore) throws Exception {
        Utilita.mostraLista(categoriaSensore.getInformazioniRilevabili());
        if (!categoriaSensore.getInformazioniRilevabili().isEmpty()) {
            int sc = Utilita.chiediIntero(INSERISCI_INFORMAZIONE_RIMOVIBILE);
            categoriaSensore.removeInformazione(categoriaSensore.getInformazioniRilevabili().get((sc - 1)));
        }
    }

    public static void visualizzaInformazioni(CategoriaSensore categoriaSensore) throws Exception {
        Utilita.mostraLista(categoriaSensore.getInformazioniRilevabili());
        if (!categoriaSensore.getInformazioniRilevabili().isEmpty()) {
        }
    }

    public static void visualizzaDescrizione(CategoriaSensore categoriaSensore) {
        Utilita.showText(categoriaSensore.getDescrizione());
    }

    public static void modificaDescrizione(CategoriaSensore categoriaSensore) {
        Utilita.showText(DESCRIZIONE_ATTUALE);
        Utilita.showText(categoriaSensore.getDescrizione());
        String newDesc = Utilita.chiediStringa(INSERISCI_DESCRIZIONE);
        categoriaSensore.setDescrizione(newDesc);
    }

}
