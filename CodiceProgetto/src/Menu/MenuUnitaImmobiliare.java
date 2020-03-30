package Menu;

import Menu.MenuDevice;
import Model.*;
import Utilita.*;

import java.util.ArrayList;

public class MenuUnitaImmobiliare {

    private static final String ESCI = "Indietro";
    private static final String MODIFICA_STANZE = "Aggiungi, visualizza, modifica o rimuovi stanze";
    private static final String MODIFICA_ARTEFATTI = "Aggiungi, visualizza, modifica o rimuovi artefatti";
    private static final String MODIFICA_DEVICES ="Aggiungi, visualizza, modifica o rimuovi devices";
    private static final String MODIFICA_CATEGORIE_SENSORI = "Aggiungi, visualizza, modifica o rimuova categorie di sensori";
    private static final String MODIFICA_CATEGORIE_ATTUATORI = "Aggiungi, visualizza, modifica o rimuova categorie di attuatori";
    private static final String ERRORE_SELEZIONE = "L'opzione selezionata non è presente";

    private static final String AGGIUNGI_CATEGORIA = "Aggiungi una nuova categoria";
    private static final String RIMUOVI_CATEGORIA = "Rimuovi una delle categorie";
    private static final String VISUALIZZA_CATEGORIE = "Visualizza le categorie";
    private static final String MODIFICA_CATEGORIA = "Modifica la categoria";

    private static final String VISUALIZZA_DATI_STANZA = "Visualizza dati riguardo la stanza e i suoi componenti";
    private static final String MODIFICA_STANZA = "Modifica dati presenti nella stanza";
    private static final String RIMUOVI_STANZA = "Rimuovi una delle stanze presenti";
    private static final String AGGIUNGI_STANZA = "Aggiungi una nuova stanza";

    private static final String VISUALIZZA_DATI_ARTEFATTO = "Visualizza dati riguardo un artefatto";
    private static final String MODIFICA_ARTEFATTO = "Modifica dati presenti nell'artefatto";
    private static final String RIMUOVI_ARTEFATTO = "Rimuovi uno degli artefatti presenti";
    private static final String AGGIUNGI_ARTEFATTO = "Aggiungi un nuovo artefatto";

    private static final String AZIONI_ARTEFATTI = "Esegui azioni sugli artefatti presenti nella stanza";

    public static boolean menuModificaUnitaImmobiliare(UnitaImmobiliare unitaImmobiliare) throws Exception {

        int sceltaAzione = Utilita.scelta(MODIFICA_STANZE, MODIFICA_ARTEFATTI, MODIFICA_DEVICES, MODIFICA_CATEGORIE_SENSORI, MODIFICA_CATEGORIE_ATTUATORI, ESCI);

        switch (sceltaAzione) {

            case 1:
                menuStanze(unitaImmobiliare.getStanze());
                break;

            case 2:
                menuArtefatti(unitaImmobiliare.getArtefatti());
                break;

            case 3:
                MenuDevice.azioniSuDevices(unitaImmobiliare);
                break;

            case 4:
                menuCategorieSensori(unitaImmobiliare.getCategorieDevice().getCategorieSensori());
                break;

            case 5:
                menuCategorieAttuatori(unitaImmobiliare.getCategorieDevice().getCategorieAttuatori());
                break;

            case 6:
                return false;

            default:
                Utilita.showText(ERRORE_SELEZIONE);
                menuModificaUnitaImmobiliare(unitaImmobiliare);
                break;
        }
        return true;
    }

    public static boolean menuCategorieSensori(ArrayList<CategoriaSensore> categorieSensori) throws Exception {
        int scelta = Utilita.scelta(AGGIUNGI_CATEGORIA, RIMUOVI_CATEGORIA, MODIFICA_CATEGORIA, VISUALIZZA_CATEGORIE, ESCI);
        switch(scelta) {

            case 1:
                UtilitaCategorie.aggiungiCategoriaSensori(categorieSensori);
                break;

            case 2:
                UtilitaCategorie.rimuoviCategoriaSensori(categorieSensori);
                break;

            case 3:
                UtilitaCategorie.modificaCategoriaSensori(categorieSensori);
                break;

            case 4:
                UtilitaCategorie.visualizzaCategorieSensori(categorieSensori);
                break;

            case 5:
                return false;

            default:
                Utilita.showText(ERRORE_SELEZIONE);
        }
        return true;
    }

    public static boolean menuCategorieAttuatori(ArrayList<CategoriaAttuatore> categorieAttuatori) throws Exception {
        int scelta = Utilita.scelta(AGGIUNGI_CATEGORIA, RIMUOVI_CATEGORIA, MODIFICA_CATEGORIA, VISUALIZZA_CATEGORIE, ESCI);
        switch(scelta) {

            case 1:
                UtilitaCategorie.aggiungiCategoriaAttuatori(categorieAttuatori);
                break;

            case 2:
                UtilitaCategorie.rimuoviCategoriaAttuatori(categorieAttuatori);
                break;

            case 3:
                UtilitaCategorie.modificaCategoriaAttuatori(categorieAttuatori);
                break;

            case 4:
                UtilitaCategorie.visualizzaCategorieAttuatori(categorieAttuatori);
                break;

            case 5:
                return false;

            default:
                Utilita.showText(ERRORE_SELEZIONE);
        }
        return true;
    }

    public static boolean menuStanze(ArrayList<Stanza> stanze) throws Exception {
        int scelta = Utilita.scelta(AGGIUNGI_STANZA, MODIFICA_STANZA, RIMUOVI_STANZA, VISUALIZZA_DATI_STANZA, ESCI);
        switch (scelta) {

            case 1:
                UtilitaUnitaImmobiliare.creaStanza(stanze);
                break;

            case 2:
                UtilitaUnitaImmobiliare.modificaStanza(stanze);
                break;

            case 3:
                UtilitaUnitaImmobiliare.rimuoviStanza(stanze);
                break;

            case 4:
                UtilitaUnitaImmobiliare.visualizzaDatiStanza(stanze);
                break;

            case 5:
                return false;

            default:
                Utilita.showText(ERRORE_SELEZIONE);
                menuStanze(stanze);
        }

        return true;
    }

    public static boolean menuArtefatti(ArrayList<Artefatto> artefatti) throws Exception {
        int scelta = Utilita.scelta(AGGIUNGI_ARTEFATTO, MODIFICA_ARTEFATTO, RIMUOVI_ARTEFATTO, VISUALIZZA_DATI_ARTEFATTO, ESCI);
        switch (scelta) {

            case 1:
                UtilitaUnitaImmobiliare.creaArtefatto(artefatti);
                break;

            case 2:
                UtilitaUnitaImmobiliare.modificaArtefatto(artefatti);
                break;

            case 3:
                UtilitaUnitaImmobiliare.rimuoviArtefatto(artefatti);
                break;

            case 4:
                UtilitaUnitaImmobiliare.visualizzaDatiArtefatto(artefatti);
                break;

            case 5:
                return false;

            default:
                Utilita.showText(ERRORE_SELEZIONE);
                menuArtefatti(artefatti);
        }

        return true;
    }

    public static boolean menuModificaStanza(Stanza stanzaDaModificare) throws Exception {
        int scelta = Utilita.scelta(AZIONI_ARTEFATTI, ESCI);
        switch (scelta) {

            case 1:
                menuArtefatti(stanzaDaModificare.getArtefatti());
                break;

            case 2:
                return false;

            default:
                Utilita.showText(ERRORE_SELEZIONE);
                menuModificaStanza(stanzaDaModificare);
        }

        return true;
    }

    public static boolean menuModificaArtefatto(Artefatto artefatto) throws Exception {
        int scelta = Utilita.scelta(ESCI);
        switch(scelta) {

            case 1:
                return false;

            default:
                Utilita.showText(ERRORE_SELEZIONE);
                menuModificaArtefatto(artefatto);

        }
        return true;
    }


}