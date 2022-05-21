package src.Files;


import src.GestorConsumoAPP;
import src.Model.Casas.GestorComunidade;

import java.io.*;

public class SaveLoadState {

    public static int saveDados(String fileName, GestorComunidade gcapp) {
        try {
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(file);
            oos.writeObject(gcapp);
            oos.flush();
            oos.close();
        }
        catch (FileNotFoundException e) {
            return 1;
        }
        catch (IOException e) {
            return 2;
        }

        return 0;
    }


    public static GestorConsumoAPP loadDados(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream file = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(file);
        GestorConsumoAPP gcapp = (GestorConsumoAPP) ois.readObject();
        ois.close();
        return gcapp;
    }


}
