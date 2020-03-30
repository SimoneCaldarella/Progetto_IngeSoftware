package Utilita;

import Model.*;
import Menu.*;

import java.util.ArrayList;

public class UtilitaCategorie {

    private static String SCEGLI_CATEGORIA = "Scegli una delle categorie presenti";
    private static String CHIEDI_NOME = "Scegli un nome per la categoria";
    private static String INSERISCI_DESCRIZIONE = "Inserisci una descrizione adeguata";

    public static void aggiungiCategoriaSensori(ArrayList<CategoriaSensore> categorieSensori) throws Exception {
        String nome = Utilita.nomeUnico(CHIEDI_NOME, categorieSensori);
        String descrizione = Utilita.chiediStringa(INSERISCI_DESCRIZIONE);
        CategoriaSensore categoriaSensore = new CategoriaSensore(nome, descrizione);
        boolean ok;
        do {
            ok = MenuDevice.modificaCategoriaSensore(categoriaSensore);
        } while (ok);
    }

    public static void visualizzaCategorieSensori(ArrayList<CategoriaSensore> categorieSensori) throws Exception {
        Utilita.mostraLista(categorieSensori);
        if(!categorieSensori.isEmpty()) {
        }
    }

    public static void rimuoviCategoriaSensori(ArrayList<CategoriaSensore> categorieSensori) throws Exception {
        Utilita.mostraLista(categorieSensori);
        if(!categorieSensori.isEmpty()) {
            int scelta = Utilita.chiediIntero(SCEGLI_CATEGORIA);
            categorieSensori.remove(scelta - 1);
        }
    }

    public static void modificaCategoriaSensori(ArrayList<CategoriaSensore> categorieSensori) throws Exception {
        Utilita.mostraLista(categorieSensori);
        if(!categorieSensori.isEmpty()) {
            int scelta = Utilita.chiediIntero(SCEGLI_CATEGORIA);
            boolean ok;
            do {
                ok = MenuDevice.modificaCategoriaSensore(categorieSensori.get(scelta - 1));
            } while (ok);
        }
    }

    public static void aggiungiCategoriaAttuatori(ArrayList<CategoriaAttuatore> categorieAttuatori) throws Exception {
        String nome = Utilita.nomeUnico(CHIEDI_NOME, categorieAttuatori);
        String descrizione = Utilita.chiediStringa(INSERISCI_DESCRIZIONE);
        CategoriaAttuatore categoriaAttuatore = new CategoriaAttuatore(nome, descrizione);
        boolean ok;
        do {
            ok = MenuDevice.modificaCategoriaAttuatore(categoriaAttuatore);
        } while (ok);
    }

    public static void visualizzaCategorieAttuatori(ArrayList<CategoriaAttuatore> categorieAttuatori) throws Exception {
        Utilita.mostraLista(categorieAttuatori);
        if(!categorieAttuatori.isEmpty()) {
        }
    }

    public static void rimuoviCategoriaAttuatori(ArrayList<CategoriaAttuatore> categorieAttuatori) throws Exception {
        Utilita.mostraLista(categorieAttuatori);
        if(!categorieAttuatori.isEmpty()) {
            int scelta = Utilita.chiediIntero(SCEGLI_CATEGORIA);
            categorieAttuatori.remove(scelta - 1);
        }
    }

    public static void modificaCategoriaAttuatori(ArrayList<CategoriaAttuatore> categorieAttuatori) throws Exception {
        Utilita.mostraLista(categorieAttuatori);
        if(!categorieAttuatori.isEmpty()) {
            int scelta = Utilita.chiediIntero(SCEGLI_CATEGORIA);
            boolean ok;
            do {
                ok = MenuDevice.modificaCategoriaAttuatore(categorieAttuatori.get(scelta - 1));
            } while (ok);
        }
    }
}
