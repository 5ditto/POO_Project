package src.View;

import src.Model.Casas.SmartHouse;
import src.Model.Fatura;

import java.util.List;

public class Apresentacao {

    public void printMaisGastadora(SmartHouse gastadora){
        System.out.println("A casa que gastou mais foi: " + gastadora.toString());
    }

    public void printFaturasEmitidas(List<Fatura> listaFaturas){
        System.out.println(listaFaturas);
    }

}

