package src.View;

import src.Model.Casas.SmartHouse;

public class Apresentacao {

    public void printMaisGastadora(SmartHouse gastadora){
        System.out.println("A casa que gastou mais foi: " + gastadora.toString());
    }
}
