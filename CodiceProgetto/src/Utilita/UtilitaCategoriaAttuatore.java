package Utilita;

import Model.*;
import Menu.*;

public class UtilitaCategoriaAttuatore {

    private static final String INSERISCI_NOME_INFORMAZIONE = "Inserisci il nome della modalità da aggiungere";
    private static final String INSERISCI_MODALITA_RIMOVIBILE = "Inserisci il nome della modalità da rimuovere";
    private static final String DESCRIZIONE_ATTUALE = "Descrizione attuale:";
    private static final String INSERISCI_DESCRIZIONE = "Inserisci la nuova descrizione";

    public static void aggiungiModalita(CategoriaAttuatore categoriaAttuatore) throws Exception {
        String nome = Utilita.nomeUnico(INSERISCI_NOME_INFORMAZIONE, categoriaAttuatore.getModalitaOperative());
        categoriaAttuatore.addModalita(new ModalitaOperativa(nome, false));
    }

    public static void rimuoviModalita(CategoriaAttuatore categoriaAttuatore) throws Exception {
        Utilita.mostraLista(categoriaAttuatore.getModalitaOperative());
        if (!categoriaAttuatore.getModalitaOperative().isEmpty()) {
            int sc = Utilita.chiediIntero(INSERISCI_MODALITA_RIMOVIBILE);
            categoriaAttuatore.removeModalita(categoriaAttuatore.getModalitaOperative().get((sc - 1)));
        }
    }

    public static void visualizzaModalita(CategoriaAttuatore categoriaAttuatore) throws Exception {
        Utilita.mostraLista(categoriaAttuatore.getModalitaOperative());
        if (!categoriaAttuatore.getModalitaOperative().isEmpty()) {
        }
    }

    public static void visualizzaDescrizione(CategoriaAttuatore categoriaAttuatore) {
        Utilita.showText(categoriaAttuatore.getDescrizione());
    }

    public static void modificaDescrizione(CategoriaAttuatore categoriaAttuatore) {
        Utilita.showText(DESCRIZIONE_ATTUALE);
        Utilita.showText(categoriaAttuatore.getDescrizione());
        String newDesc = Utilita.chiediStringa(INSERISCI_DESCRIZIONE);
        categoriaAttuatore.setDescrizione(newDesc);
    }

}
