package Utilita;

import Utilita.Utilita;

import java.util.ArrayList;
import Model.*;
import Menu.*;

public class UtilitaUsoUnita {

    private static final String SCEGLI_DEVICE = "Scegli un device";
    private static final String SCEGLI_STANZA = "Scegli una stanza";
    private static final String SCEGLI_ARTEFATTO = "Scegli un artefatto";

    public static void visualizzaDevices(ArrayList<Device> devices) throws Exception {
        Utilita.mostraLista(devices);
    }

    public static void scegliDevice(ArrayList<Device> devices) throws Exception {
        Utilita.mostraLista(devices);
        if (!devices.isEmpty()) {
            int scelta = Utilita.chiediIntero(SCEGLI_DEVICE)-1;
            Device device = devices.get(scelta-1);
            if (device instanceof Sensore) {
                MenuUtente.menuSensore((Sensore) device);
            } else {
                MenuUtente.menuAttuatore((Attuatore) device);
            }
        }
    }

    public static void scegliStanza(ArrayList<Stanza> stanze) throws Exception {
        Utilita.mostraLista(stanze);
        if (!stanze.isEmpty()) {
            int scelta = Utilita.chiediIntero(SCEGLI_STANZA)-1;
            MenuUtente.menuStanza(stanze.get(scelta));
        }
    }

    public static void scegliArtefatto(ArrayList<Artefatto> artefatti) throws Exception {
        Utilita.mostraLista(artefatti);
        if (!artefatti.isEmpty()) {
            int scelta = Utilita.chiediIntero(SCEGLI_ARTEFATTO)-1;
            MenuUtente.menuArtefatto(artefatti.get(scelta));
        }
    }

}
