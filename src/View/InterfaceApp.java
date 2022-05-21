package src.View;

import src.Model.Casas.GestorComunidade;
import src.Model.Casas.SmartHouse;
import src.Model.Comercializadores.Comercializador;
import src.Model.Fatura.Fatura;
import src.Model.SmartDevice.SmartDevice;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;


public interface InterfaceApp {
    public void welcome();

    public void printMessage(String message);

    public void printline(String s);

    public void printOpInvalida();

    public void printNextSimulation();

    public void printMainMenu();

    public void printMenuTurnOffON() ;

    public void printMenuTurnDivisionDevice();

    public void printMaisGastadora(SmartHouse g);

    public void printCustosEGastos(Fatura last);

    public void printFaturasEmitidas(List<Fatura> faturas);

    public void printComercializadorMaisFaturacao(Comercializador c, Double volume);

    public void printMaiorConsumidorTempo(Map<Double,SmartHouse> c, LocalDate inicio, LocalDate fim, int consumidor);

    public void printCasas(GestorComunidade gc);

    public void printComercializadores(GestorComunidade gc);

    public void printDivisoes(SmartHouse c);

    public void printDevicesDivisao(SmartHouse c, String divisao);

}

