package Menu;

import Model.*;
import Utilita.*;

public class MenuDevice {

    private static final String ERRORE_SELEZIONE = "L'opzione selezionata non è presente";
    private static final String AGGIUNGI_DEVICE = "Aggiungi un nuovo device";
    private static final String RIMUOVI_DEVICES = "Rimuovi un device";
    private static final String VISUALIZZA_DEVICES = "Mostra la lista dei devices presenti";
    private static final String ESCI = "Indietro";

    private static final String AGGIUNGI_INFORMAZIONE = "Aggiungi una nuova informazione rilevabile";
    private static final String RIMUOVI_INFORMAZIONE = "Rimuovi una delle informazioni rilevabili";
    private static final String VISUALIZZA_INFORMAZIONI = "Visualizza le informazioni rilevabili";
    private static final String MODIFICA_DESCRIZIONE = "Modifica la descrizione della categoria";
    private static final String VISUALIZZA_DESCRIZIONE = "Visualizza la descrizione";

    private static final String AGGIUNGI_MODALITA = "Aggiungi una nuova modalità operativa";
    private static final String RIMUOVI_MODALITA = "Rimuovi una modalità operativa";
    private static final String VISUALIZZA_MODALITA = "Visualizza le modalità operative";

    public static boolean azioniSuDevices(UnitaImmobiliare unitaImmobiliare) throws Exception {
        int scelta = Utilita.scelta(AGGIUNGI_DEVICE, RIMUOVI_DEVICES, VISUALIZZA_DEVICES, ESCI);
        switch (scelta) {
            case 1:
                UtilitaDevice.creaDevice(unitaImmobiliare);
                break;

            case 2:
                UtilitaDevice.rimuoviDevice(unitaImmobiliare.getDevices());
                break;

            case 3:
                UtilitaDevice.visualizzaDevices(unitaImmobiliare.getDevices());
                break;

            case 4:
                return false;

            default:
                Utilita.showText(ERRORE_SELEZIONE);

        }
        return true;
    }

    public static boolean modificaCategoriaSensore(CategoriaSensore categoriaSensore) throws Exception {

        int s = Utilita.scelta(AGGIUNGI_INFORMAZIONE, RIMUOVI_INFORMAZIONE, VISUALIZZA_INFORMAZIONI, VISUALIZZA_DESCRIZIONE, MODIFICA_DESCRIZIONE, ESCI);

        switch (s) {

            case 1:
                UtilitaCategoriaSensore.aggiungiInformazione(categoriaSensore);
                break;

            case 2:
                UtilitaCategoriaSensore.rimuoviInformazione(categoriaSensore);
                break;

            case 3:
                UtilitaCategoriaSensore.visualizzaInformazioni(categoriaSensore);
                break;

            case 4:
                UtilitaCategoriaSensore.visualizzaDescrizione(categoriaSensore);
                break;

            case 5:
                UtilitaCategoriaSensore.modificaDescrizione(categoriaSensore);
                break;

            case 6:
                return false;

            default:
                Utilita.showText(ERRORE_SELEZIONE);

        }

        return true;

    }

    public static boolean modificaCategoriaAttuatore(CategoriaAttuatore categoriaAttuatore) throws Exception {

        int s = Utilita.scelta(AGGIUNGI_MODALITA, RIMUOVI_MODALITA, VISUALIZZA_MODALITA, VISUALIZZA_DESCRIZIONE, MODIFICA_DESCRIZIONE, ESCI);

        switch (s) {

            case 1:
                UtilitaCategoriaAttuatore.aggiungiModalita(categoriaAttuatore);
                break;

            case 2:
                UtilitaCategoriaAttuatore.rimuoviModalita(categoriaAttuatore);
                break;

            case 3:
                UtilitaCategoriaAttuatore.visualizzaModalita(categoriaAttuatore);
                break;

            case 4:
                UtilitaCategoriaAttuatore.visualizzaDescrizione(categoriaAttuatore);
                break;

            case 5:
                UtilitaCategoriaAttuatore.modificaDescrizione(categoriaAttuatore);
                break;

            case 6:
                return false;

            default:
                Utilita.showText(ERRORE_SELEZIONE);
        }
        return true;
    }

}
