package Model;

import Model.CategoriaAttuatore;
import Model.CategoriaSensore;

import java.io.Serializable;
import java.util.ArrayList;

public class CategorieDevice implements Serializable {

    private ArrayList<CategoriaSensore> categorieSensori;
    private ArrayList<CategoriaAttuatore> categorieAttuatori;

    public CategorieDevice() {
        categorieAttuatori = new ArrayList<>();
        categorieSensori = new ArrayList<>();
    }

    public ArrayList<CategoriaAttuatore> getCategorieAttuatori() {
        return categorieAttuatori;
    }

    public ArrayList<CategoriaSensore> getCategorieSensori() {
        return categorieSensori;
    }
}
