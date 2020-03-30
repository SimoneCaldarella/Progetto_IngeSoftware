package Utilita;

import Utilita.Utilita;
import Model.*;
import Menu.*;

import java.util.ArrayList;

public class UtilitaDevice {

    private static final String RICHIESTA_TIPOLOGIA = "Inserisci il tipo di device da creare";
    private static final String SENSORE = "Model.Sensore";
    private static final String ATTUATORE = "Atturatore";
    private static final String INSERISCI_NOME = "Inserisci il nome del device nel seguente formato [nome_tipologia]";
    private static final String ERRORE = "Scelta inesistente";
    private static final String INSERISCI_CATEGORIA = "Inserisci la categoria scelta";
    private static final String DEVICE_DA_RIMUOVERE = "Seleziona il device da rimuovere";
    private static final String SCELTA_ASSOCAZIONE = "Scegli a cosa associarlo";
    private static final String SCEGLI_STANZA = "Scegli una stanza";
    private static final String VINCOLI_VIOLATI = "Scegli un'altra stanza";
    private static final String RICHIESTA_CONTINUARE = "Vuoi continuare con l'associazione?";
    private static final String RICHIESTA_LOCAZIONE_ARTEFATTI = "Dove si trova il tuo artefatto?";
    private static final String SCEGLI_ARTEFATTO = "Scegli un artefatto";

    public static void creaDevice(UnitaImmobiliare unitaImmobiliare) throws Exception {
        if (!unitaImmobiliare.getCategorieDevice().getCategorieSensori().isEmpty() && !unitaImmobiliare.getCategorieDevice().getCategorieAttuatori().isEmpty()) {
            Utilita.showText(RICHIESTA_TIPOLOGIA);
            int s = Utilita.scelta(SENSORE, ATTUATORE);
            Device device;
            if (s == 1) {
                device = creaSensore(unitaImmobiliare);
            } else {
                device = creaAttuatore(unitaImmobiliare);
            }
            unitaImmobiliare.getDevices().add(device);
            sceltaAssociazione(device, unitaImmobiliare);
        }
    }

    public static Sensore creaSensore(UnitaImmobiliare unitaImmobiliare) throws Exception {
        ArrayList<Device> devices = unitaImmobiliare.getDevices();
        ArrayList<CategoriaSensore> categorieSensori = unitaImmobiliare.getCategorieDevice().getCategorieSensori();
        Utilita.mostraLista(categorieSensori);
        CategoriaSensore categoriaSensore = categorieSensori.get(Utilita.chiediIntero(INSERISCI_CATEGORIA)-1);
        boolean ok;
        String nome;
        do {
            nome = Utilita.chiediStringa(INSERISCI_NOME)+"_"+categoriaSensore.getNome();
            ok = Utilita.controlloUnicita(nome, devices);
        } while (!ok);
        Sensore sensore = new Sensore(nome, categoriaSensore);
        return sensore;
    }

    public static Attuatore creaAttuatore(UnitaImmobiliare unitaImmobiliare) throws Exception {
        ArrayList<Device> devices = unitaImmobiliare.getDevices();
        ArrayList<CategoriaAttuatore> categorieAttuatori = unitaImmobiliare.getCategorieDevice().getCategorieAttuatori();
        Utilita.mostraLista(categorieAttuatori);
        CategoriaAttuatore categoriaAttuatore = categorieAttuatori.get(Utilita.chiediIntero(INSERISCI_CATEGORIA)-1);
        String nome;
        boolean ok;
        do {
            nome = Utilita.chiediStringa(INSERISCI_NOME)+"_"+categoriaAttuatore.getNome();
            ok = Utilita.controlloUnicita(nome, devices);
        } while (!ok);
        Attuatore attuatore = new Attuatore(nome, categoriaAttuatore);
        return attuatore;
    }

    public static void rimuoviDevice(ArrayList<Device> devices) throws Exception {
        Utilita.mostraLista(devices);
        if (!devices.isEmpty()) {
            int sc = Utilita.chiediIntero(DEVICE_DA_RIMUOVERE);
            devices.remove((sc - 1));
        }
    }

    public static void visualizzaDevices(ArrayList<Device> devices) throws Exception {
        Utilita.mostraLista(devices);
        if (!devices.isEmpty()) {
        }
    }

    public static void sceltaAssociazione(Device device, UnitaImmobiliare unitaImmobiliare) throws Exception {
        Utilita.showText(SCELTA_ASSOCAZIONE);
        ArrayList<Stanza> stanze = unitaImmobiliare.getStanze();
        ArrayList<Artefatto> artefatti = unitaImmobiliare.getArtefatti();
        int scelta = Utilita.scelta("Stanze", "Artefatti");
        if (scelta == 1) {
            int sc;
            int ciclo = 1;
            do {
                boolean ok = true;
                do {
                    Utilita.mostraLista(stanze);
                    sc = Utilita.chiediIntero(SCEGLI_STANZA) - 1;
                    for (Device d : stanze.get(sc).getDevices()) {
                        if (getCategoryName(d).equals(getCategoryName(device))) {
                            Utilita.showText(VINCOLI_VIOLATI);
                            ok = false;
                            break;
                        }
                    }
                } while (!ok);
                device.addStanza(stanze.get(sc));
                stanze.get(sc).getDevices().add(device);
                Utilita.showText(RICHIESTA_CONTINUARE);
                ciclo = Utilita.scelta("Si", "No");
            } while (ciclo == 1);
        } else if (scelta == 2) {
            Utilita.showText(RICHIESTA_LOCAZIONE_ARTEFATTI);
            int sceltaLocazione = Utilita.scelta("In una stanza", "Nell'unità");
            if (sceltaLocazione == 1) {
                Utilita.mostraLista(stanze);
                int sceltaStanza = Utilita.chiediIntero(SCEGLI_STANZA);
                Stanza stanzaScelta = stanze.get(sceltaStanza);
                ArrayList<Artefatto> artefattiInStanza = stanzaScelta.getArtefatti();

                int sc;
                int ciclo = 1;
                do {
                    boolean ok = true;
                    do {
                        Utilita.mostraLista(artefattiInStanza);
                        sc = Utilita.chiediIntero(SCEGLI_ARTEFATTO) - 1;
                        for (Device d : artefattiInStanza.get(sc).getDevices()) {
                            if (getCategoryName(d).equals(getCategoryName(device))) {
                                Utilita.showText(VINCOLI_VIOLATI);
                                ok = false;
                                break;
                            }
                        }
                    } while (!ok);
                    device.addArtefatto(artefattiInStanza.get(sc));
                    artefattiInStanza.get(sc).getDevices().add(device);
                    Utilita.showText(RICHIESTA_CONTINUARE);
                    ciclo = Utilita.scelta("Si", "No");
                } while (ciclo == 1);
            } else {
                int sc;
                int ciclo = 1;
                do {
                    boolean ok = true;
                    do {
                        Utilita.mostraLista(artefatti);
                        sc = Utilita.chiediIntero(SCEGLI_ARTEFATTO) - 1;
                        for (Device d : artefatti.get(sc).getDevices()) {
                            if (getCategoryName(d).equals(getCategoryName(device))) {
                                Utilita.showText(VINCOLI_VIOLATI);
                                ok = false;
                                break;
                            }
                        }
                    } while (!ok);
                    device.addArtefatto(artefatti.get(sc));
                    artefatti.get(sc).getDevices().add(device);
                    Utilita.showText(RICHIESTA_CONTINUARE);
                    ciclo = Utilita.scelta("Si", "No");
                } while (ciclo == 1);
            }
        } else {
            Utilita.showText(ERRORE);
            sceltaAssociazione(device, unitaImmobiliare);
        }
    }

    public static String getCategoryName(Device device) {
        String segments[] = device.getNome().split("_");
        String categoryName = segments[segments.length - 1];
        return categoryName;
    }

}