package src;


import src.Controller.Interpretador;
import src.Files.FileInvalidException;
import src.Files.Parser;
import src.Model.*;
import src.view.ApresentacaoMain;

public class GestaoConsumo {
    public static void main(String[] args){
        GestorComunidade gc     = new GestorComunidade();   // Model
        Interpretador    i      = new Interpretador();      // Controlador
        ApresentacaoMain a      = new ApresentacaoMain();   // View
        Parser           parser = new Parser();             // Parser

        parser.parse(gc);

        //i.interpretador(gc, a);
    }
}
