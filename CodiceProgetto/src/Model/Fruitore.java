package Model;

import Model.Device;

import java.util.ArrayList;

public class Fruitore extends Utente {

    public Fruitore(String name, ArrayList<UnitaImmobiliare> unitaImmobiliari) {
        setName(name);
        setTipo(1);
        setUnitaImmobiliari(unitaImmobiliari);
    }

    public static void datiDevice(Device device){
    }

    public static void infoSensore(Sensore sensore) throws Exception {
        //UtilitaSensore.visualizzaInformazioni(sensore);
    }
}
