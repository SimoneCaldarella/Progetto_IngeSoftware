package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class CategoriaSensore implements Serializable {

    private String nome;
    private String descrizione;
    private ArrayList<InformazioneRilevabile> informazioniRilevabili;

    public CategoriaSensore(String nome, String Descrizione) {
        this.nome = nome;
        informazioniRilevabili = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public ArrayList<InformazioneRilevabile> getInformazioniRilevabili() {
        return informazioniRilevabili;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void addInformazione(InformazioneRilevabile informazioneRilevabile) {
        this.informazioniRilevabili.add(informazioneRilevabile);
    }

    public void removeInformazione(InformazioneRilevabile informazioneRilevabile) {
        this.informazioniRilevabili.remove(informazioneRilevabile);
    }

}
