package src.View;

import src.Model.Casas.SmartHouse;
import src.Model.Fatura.Fatura;

import java.util.List;
import java.util.Map;

public interface InterfaceApp {
    public void welcome();

    public void printMessage(String message);

    public void printSHouse(SmartHouse l);

    public void printOption(Map<Integer,String> menu);

    public void printline(String s);

    public void printMainMenu();

    //public void printSimulationMenu();

    public void printMenuTurnOffON();

    public void printMaisGastadora(SmartHouse g);

    public void printFaturasEmitidas(List<Fatura> faturas);

    public void clearScreen();

}

