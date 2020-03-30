package Model;

import Model.CategoriaSensore;
import Model.Device;
import Model.InformazioneRilevabile;
import Utilita.Utilita;

import java.io.Serializable;
import java.util.ArrayList;

public class Sensore extends Device implements Serializable {

    private CategoriaSensore categoriaSensore;

    public Sensore(String nome, CategoriaSensore categoriaSensore) {
        setNome(nome+"_"+categoriaSensore.getNome());
        this.categoriaSensore = categoriaSensore;
        attiva(); //Nella prima versione tutti i sensori sono attivi;
    }

    public ArrayList<InformazioneRilevabile> getInformazioniRilevabili() {
        return categoriaSensore.getInformazioniRilevabili();
    }

    public String getDescrizione() {
        return categoriaSensore.getDescrizione();
    }

    public void rilevaInformazione(InformazioneRilevabile informazioneRilevabile) {
        Utilita.showText("Rilevazione "+informazioneRilevabile.getNome());
    }

    public CategoriaSensore getCategoriaSensore() {
        return categoriaSensore;
    }
}
