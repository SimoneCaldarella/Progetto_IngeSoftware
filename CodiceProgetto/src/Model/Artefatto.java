package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Artefatto implements Serializable{

    private String nome;
    private ArrayList<Device> devices;

    public Artefatto(String name) {
        this.nome = nome;
        this.devices = new ArrayList<Device>();
    }

    public ArrayList<Device> getDevices() {
        return devices;
    }

    public String getNome() {
        return nome;
    }
}