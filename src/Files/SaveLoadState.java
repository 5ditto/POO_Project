package src.Files;


import src.GestorConsumoAPP;
import src.Model.Casas.GestorComunidade;

import java.io.*;

public class SaveLoadState {

    public static int saveDados(String fileName, GestorComunidade gc) {
        try {
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(file);
            oos.writeObject(gc);
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


    public static GestorComunidade loadDados(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream file = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(file);
        GestorComunidade gc = (GestorComunidade) ois.readObject();
        ois.close();
        return gc;
    }


}
