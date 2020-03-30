package Utilita;

import Utilita.Utilita;
import Model.*;
import Menu.*;

import java.io.*;
import java.util.ArrayList;

public class UtilitaSistema {

    private static final String NESSUN_SALVATAGGIO = "Nessun salvataggio trovato";
    private static final String NOME_TXT = "numeroDiUnita.txt";
    private static final String ERRORE = "Errore";
    private static final String SALVATAGGIO = "Salvataggio dati...";
    private static final String USCITA = "Sei uscito dal sistema!";

    //uscita dal sistema
    public static void esciDalSistema(ArrayList<UnitaImmobiliare> unitaImmobiliari) {
        Utilita.showText(SALVATAGGIO);
        salvaDati(unitaImmobiliari);
        Utilita.showText(USCITA);
    }

    public static void salvaDati(ArrayList<UnitaImmobiliare> unitaImmobiliari) {
        for (int i = 0; i < unitaImmobiliari.size(); i++) {

            try {
                FileOutputStream myFileOutputStream = new FileOutputStream("unitaImmobiliare" + i + ".ser");
                ObjectOutputStream myObjectOutputStream = new ObjectOutputStream(myFileOutputStream);
                myObjectOutputStream.writeObject(unitaImmobiliari.get(i));
                myObjectOutputStream.close();
            } catch (Exception e) {
                Utilita.showText(ERRORE);
            }
        }

        try {
            FileWriter fileWriter = new FileWriter(NOME_TXT);
            fileWriter.write(unitaImmobiliari.size()+"\n");
            fileWriter.close();
        }
        catch(IOException ex) {
            Utilita.showText(ERRORE);
        }

    }

    public static ArrayList<UnitaImmobiliare> caricaDati() {
        ArrayList<UnitaImmobiliare> unitaImmobiliari = new ArrayList<>();
        int numero = 0;
        UnitaImmobiliare nuovaUnita;
        try {
            FileReader fileReader = new FileReader(NOME_TXT);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            line = bufferedReader.readLine();
            numero = Integer.parseInt(line.trim());
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            Utilita.showText(NESSUN_SALVATAGGIO);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < numero; i++) {
            try {
                FileInputStream myFileInputStream = new FileInputStream("unitaImmobiliare"+i+".ser");
                ObjectInputStream myObjectInputStream = null;
                try {
                    myObjectInputStream = new ObjectInputStream(myFileInputStream);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                nuovaUnita = (UnitaImmobiliare) myObjectInputStream.readObject();
                unitaImmobiliari.add(nuovaUnita);
                myObjectInputStream.close();
            } catch (Exception e) {
                Utilita.showText(ERRORE);
            }
        }
        return unitaImmobiliari;

    }


}