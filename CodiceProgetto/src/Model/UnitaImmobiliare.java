package Model;

import Model.Artefatto;
import Model.CategorieDevice;
import Model.Device;
import Model.Stanza;

import java.io.Serializable;
import java.util.ArrayList;

public class UnitaImmobiliare implements Serializable{
    private String nome;
    private String tipologia;
    private ArrayList<Stanza> stanze;
    private ArrayList<Artefatto> artefatti;
    private ArrayList<Device> devices;
    private CategorieDevice categorieDevice;

    public UnitaImmobiliare(String nome, String tipologia, ArrayList<Stanza> stanze, ArrayList<Artefatto> artefatti){
        this.nome = nome;
        this.tipologia = tipologia;
        this.stanze = stanze;
        this.artefatti = artefatti;
        this.devices = new ArrayList<>();
        this.categorieDevice = new CategorieDevice();
    }

    public String getNome() {
        return nome;
    }
    public String getTipologia() {
        return tipologia;
    }
    public ArrayList<Stanza> getStanze(){
        return stanze;
    }
    public ArrayList<Artefatto> getArtefatti() { return artefatti; }
    public ArrayList<Device> getDevices() {
        return devices;
    }

    public CategorieDevice getCategorieDevice() {
        return categorieDevice;
    }

    public void addStanza(Stanza stanza){
        stanze.add(stanza);
    }
    public void  removeStanza(Stanza stanza){
        stanze.remove(stanza);
    }

    public void addArtefatto(Artefatto artefatto){
        artefatti.add(artefatto);
    }
    public void removeArtefatto(Artefatto artefatto){
        artefatti.remove(artefatto);
    }


}