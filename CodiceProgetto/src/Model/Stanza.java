package Model;

import Model.Artefatto;
import Model.Device;

import java.io.Serializable;
import java.util.ArrayList;

public class Stanza implements Serializable {

    private String nome;
    private ArrayList<Artefatto> artefatti;
    private ArrayList<Device> devices;

    public Stanza(String nome) {
        this.nome = nome;
        this.artefatti = new ArrayList<Artefatto>();
        this.devices = new ArrayList<Device>();
    }

    public ArrayList<Artefatto> getArtefatti(){ return artefatti; }

    public ArrayList<Device> getDevices() {
        return devices;
    }

    public String getNome() { return nome; }

    public void removeArtefatto(Artefatto artefatto) {
        artefatti.remove(artefatto);
    }
    public void addArtefatto(Artefatto artefatto) {
        artefatti.add(artefatto);
    }

}