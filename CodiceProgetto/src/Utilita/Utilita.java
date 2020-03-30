package Utilita;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Scanner;

public class Utilita<T> {

    public static Scanner scan;
    public static final String NESSUN_ELEMENTO = "Nessun elemento presente";


    //Server a wrapparti la funzione di standard di output in modo tale che se vogliamo cambiare output basta modificare sto metodo
    //Tutto il flusso output passa da qua
    public static void showText(String sentence){
        System.out.println(sentence);
    }

    public static void showTextForAsk(String sentence) { System.out.print(sentence+": "); }

    //Crea i menu grafici
    public static void createGraphicMenu(Object... args){

        showText("-----------------------------------------");
        for (int i=0; i<args.length; i++){
            showText((i+1)+") "+args[i].toString());
        }
        showText("-----------------------------------------");

    }

    //Metodo usato per mostrare l'elenco di nomi di una lista
    public static <T> void mostraLista(ArrayList<T> things) throws Exception {

        String name = null;
        Method field;
        if (things.size() > 0) {
            for (int i = 0; i < things.size(); i++) {
                try {
                    field = things.get(i).getClass().getSuperclass().getDeclaredMethod("getNome");
                } catch (Exception e) {
                    field = things.get(i).getClass().getDeclaredMethod("getNome");
                }
                name = (String) field.invoke(things.get(i));
                showText((i + 1) + ") " + name);
            }
        } else {
            showText(NESSUN_ELEMENTO);
        }

    }

    public static <T> String [] ritornaNomiLista(ArrayList<T> things) throws Exception {

        String[] names = new String[things.size()];
        Method field;
        for (int i=0; i<things.size(); i++){
            try {
                field = things.get(i).getClass().getSuperclass().getDeclaredMethod("getNome");
            } catch (Exception e) {
                field = things.get(i).getClass().getDeclaredMethod("getNome");
            }
            names[i] = (String) field.invoke(things.get(i));

        }
        return names;
    }

    //Riceve la lista di oggetti che devono avere un unico nome, se il nome non esiste precedentemente allora ritorna
    //true, ossia è vero che il nome dato in input è unico
    public static <T> boolean controlloUnicita(String nome, ArrayList<T> things) throws Exception {
        String[] names = ritornaNomiLista(things);
        for (String name: names) {
            if (nome.equals("nome")) { return false; }
        }
        return true;
    }

    public static <T> String nomeUnico(String frase, ArrayList<T> things) throws Exception {
        boolean ok;
        String nome;

        do {
            nome = Utilita.chiediStringa(frase);
            ok = Utilita.controlloUnicita(nome, things);
            if (!ok) { Utilita.showText("Scegliere un'altro nome"); }
        } while (!ok);

        return nome;
    }

    //Usa il menu grafico e ti ritorna in output il numero corrispondente alla scelta fatta
    public static int scelta(String... args){
        scan = new Scanner(System.in);
        createGraphicMenu(args);
        showTextForAsk("Scelta: ");
        return scan.nextInt();
    }

    //Quando vuoi chiedere di inserire una stringa usi questa funzione che in input ha la frase da inserire
    //e ti ritorna la stringa inserira e riceve in input
    public static String chiediStringa(String frase) {
        showTextForAsk(frase);
        scan = new Scanner(System.in);
        return scan.next();
    }

    //Quando vuoi chiedere di inserire un numero usi questa funzione che in input ha la frase da inserire
    //e ti ritorna la stringa inserira e riceve in input
    //Modificalo con float o fanne un'altra con float se serve
    public static int chiediIntero(String frase) {
        showTextForAsk(frase);
        scan = new Scanner(System.in);
        return scan.nextInt();
    }

}