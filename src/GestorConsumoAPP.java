package src;


import src.Controller.Interpretador;
import src.Files.LinhaIncorretaException;
import src.Files.Parser;
import src.Model.Casas.GestorComunidade;
import src.View.Apresentacao;

import java.io.Serializable;

public class GestorConsumoAPP implements Serializable {

    public static void main(String[] args) {

        GestorComunidade gc = new GestorComunidade();   // Model
        Interpretador i;                                // Controlador
        Apresentacao a = new Apresentacao();            // View
        Parser parser = new Parser();                   // Parser


        try {
            parser.parse(gc);
        } catch (LinhaIncorretaException e) {
            a.printMessage("Wrong Format for Input File");
        }



        try{
            i = new Interpretador(a,gc);
            i.interpretador();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }


}
