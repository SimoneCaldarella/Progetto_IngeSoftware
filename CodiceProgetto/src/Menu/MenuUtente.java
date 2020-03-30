package Menu;

import Model.*;
import Utilita.*;

import java.util.ArrayList;

public class MenuUtente {

    private final static String BENVENUTO_MANUTENTORE = "Benvenuto nel sistema come manutentore, cosa vuoi fare?";
    private final static String AGGIUNGI_UNITA = "Crea una nuova unità immobiliare";
    private final static String MODIFICA_UNITA = "Modifica un'unità immobiliare esistente";
    private final static String ELIMINA_UNITA = "Elimina un'unità immobiliare dalla lista";
    private final static String VISUALIZZA = "Visualizza i dati di un'unità immobiliare";

    private final static String BENVENUTO_FRUITORE = "Benvenuto nel sistema come fruitore, cosa vuoi fare?";

    private final static String SCELTA_ERRATA ="La scelta fatta non esiste. Cambiare scelta";
    private final static String ESCI = "Indietro";

    private final static String MAX_EXCEEDED = "Hai già creato troppe unità";
    private final static String VISUALIZZA_DEVICES = "Visualizza i devices";
    private final static String VISUALIZZA_STANZE = "Visualizza le stanze";
    private final static String VISUALIZZA_ARTEFATTI = "Visualizza gli artefatti";
    private final static String SCEGLI_DEVICE = "Visualizza un device specifico";

    private final static String VISUALIZZA_INFORMAZIONI = "Visualizza le informazioni rilevabili";
    private final static String VISUALIZZA_TIPOLOGIA = "Visualizza la tipologia di device";
    private final static String VISUALIZZA_DESCRIZIONE_TIPOLOGIA = "Visualizza la descrizione della tipologia";
    private final static String VISUALIZZA_MODALITA = "Visualizza le modalità operative";

    private final static String SELEZIONA_STANZA = "Seleziona una stanza";
    private final static String SELEZIONA_ARTEFATTO = "Seleziona un artefatto";

    public static boolean menuPrincipaleManutentore(Manutentore manutentore) throws Exception {

        Utilita.showText(BENVENUTO_MANUTENTORE);
        int scelta = Utilita.scelta(AGGIUNGI_UNITA, MODIFICA_UNITA, ELIMINA_UNITA, VISUALIZZA, ESCI);

        switch (scelta) {
            case 1:
                if (manutentore.getUnitaImmobiliari().size() > Sistema.maxNumeroUnita ) {
                    Utilita.showText(MAX_EXCEEDED);
                } else {
                    UtilitaManutentore.aggiungiUnitaImmobiliare(manutentore);
                }
                break;
            case 2:
                UtilitaManutentore.modificaUnitaImmobiliare(manutentore);
                break;
            case 3:
                UtilitaManutentore.rimuoviUnitaImmobiliare(manutentore);
                break;
            case 4:
                UtilitaUtente.visualizzaDatiUI(manutentore);
                break;
            case 5:
                return false;
            default:
                Utilita.showText(SCELTA_ERRATA);
                menuPrincipaleManutentore(manutentore);
        }
        return true;
    }

    public static boolean menuPrincipaleFruitore(Fruitore fruitore) throws Exception {

        Utilita.showText(BENVENUTO_FRUITORE);
        int scelta = Utilita.scelta(VISUALIZZA, ESCI);

        switch (scelta) {
            case 1:
                UtilitaUtente.visualizzaDatiUI(fruitore);
            case 2:
                return false;
            default:
                Utilita.showText(SCELTA_ERRATA);
                menuPrincipaleFruitore(fruitore);
        }
        return true;

    }

    //A seguire i menu per esplorare un'unita;

    public static boolean menuVisualizzaDatiUnita(UnitaImmobiliare unitaImmobiliare) throws Exception {
        int scelta = Utilita.scelta(VISUALIZZA_DEVICES, VISUALIZZA_STANZE, VISUALIZZA_ARTEFATTI, ESCI);

        switch(scelta) {

            case 1:
                menuDevices(unitaImmobiliare.getDevices());
                break;

            case 2:
                menuStanze(unitaImmobiliare.getStanze());
                break;

            case 3:
                menuArtefatti(unitaImmobiliare.getArtefatti());
                break;

            case 4:
                return false;

            default:
                Utilita.showText(SCELTA_ERRATA);

        }

        return true;
    }

    public static void menuDevices(ArrayList<Device> devices) throws Exception {
        int scelta = Utilita.scelta(VISUALIZZA_DEVICES, SCEGLI_DEVICE, ESCI);

        switch(scelta) {

            case 1:
                UtilitaUsoUnita.visualizzaDevices(devices);
                break;

            case 2:
                UtilitaUsoUnita.scegliDevice(devices);
                break;

            case 3:
                break;

            default:
                Utilita.showText(SCELTA_ERRATA);
        }
    }

    public static void menuSensore(Sensore sensore) throws Exception {
        int scelta = Utilita.scelta(VISUALIZZA_TIPOLOGIA, VISUALIZZA_DESCRIZIONE_TIPOLOGIA, VISUALIZZA_INFORMAZIONI, ESCI);
        switch (scelta) {

            case 1:
                Utilita.showText(sensore.getCategoriaSensore().getNome());
                break;

            case 2:
                Utilita.showText(sensore.getDescrizione());
                break;

            case 3:
                Utilita.mostraLista(sensore.getInformazioniRilevabili());

            case 4:
                break;

            default:
                Utilita.showText(SCELTA_ERRATA);
        }

    }

    public static void menuAttuatore(Attuatore attuatore) throws Exception {
        int scelta = Utilita.scelta(VISUALIZZA_TIPOLOGIA, VISUALIZZA_DESCRIZIONE_TIPOLOGIA, VISUALIZZA_MODALITA, ESCI);
        switch (scelta) {

            case 1:
                Utilita.showText(attuatore.getCategoriaAttuatore().getNome());
                break;

            case 2:
                Utilita.showText(attuatore.getDescrizione());
                break;

            case 3:
                Utilita.mostraLista(attuatore.getModalitaOperative());

            case 4:
                break;

            default:
                Utilita.showText(SCELTA_ERRATA);
        }
    }

    public static void menuStanze(ArrayList<Stanza> stanze) throws Exception {
        int scelta = Utilita.scelta(VISUALIZZA_STANZE, SELEZIONA_STANZA, ESCI);
        switch (scelta) {

            case 1:
                Utilita.mostraLista(stanze);
                break;

            case 2:
                UtilitaUsoUnita.scegliStanza(stanze);
                break;

            case 3:
                break;

            default:
                Utilita.showText(SCELTA_ERRATA);

        }

    }

    public static void menuArtefatti(ArrayList<Artefatto> artefatti) throws Exception {

        int scelta = Utilita.scelta(VISUALIZZA_ARTEFATTI, SELEZIONA_ARTEFATTO, ESCI);
        switch (scelta) {

            case 1:
                Utilita.mostraLista(artefatti);
                break;

            case 2:
                UtilitaUsoUnita.scegliArtefatto(artefatti);
                break;

            case 3:
                break;

            default:
                Utilita.showText(SCELTA_ERRATA);

        }

    }

    public static void menuStanza(Stanza stanza) throws Exception {
        int scelta = Utilita.scelta(VISUALIZZA_DEVICES, VISUALIZZA_ARTEFATTI, ESCI);
        switch (scelta) {

            case 1:
                menuDevices(stanza.getDevices());
                break;

            case 2:
                menuArtefatti(stanza.getArtefatti());
                break;

            case 3:
                break;

            default:
                Utilita.showText(SCELTA_ERRATA);

        }
    }

    public static void menuArtefatto(Artefatto artefatto) throws Exception {

        int scelta = Utilita.scelta(VISUALIZZA_DEVICES, ESCI);
        switch (scelta) {

            case 1:
                menuDevices(artefatto.getDevices());
                break;

            case 2:
                break;

            default:
                Utilita.showText(SCELTA_ERRATA);

        }

    }

}




































