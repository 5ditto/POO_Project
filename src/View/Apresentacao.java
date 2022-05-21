package src.View;

import src.Model.Casas.SmartHouse;
import src.Model.Comercializadores.Comercializador;
import src.Model.Fatura.Fatura;
import src.Model.SmartDevice.SmartDevice;

import java.time.LocalDate;
import java.util.List;

public class Apresentacao implements InterfaceApp {
    private final Output out; //Imprime os outputs
    private ApresentacaoMain ap; // Apresentação responsável pelos outputs relacionados os resultados


    public Apresentacao(){
        out = new Output();
        ap  = new ApresentacaoMain();
    }

    /*
        Apresentação do menu de Boas-vindas
     */
    public void welcome(){
        System.out.println("##########################################");
        System.out.println("#                                        #");
        System.out.println("#                                        #");
        System.out.println("#     GESTÃO DE CONSUMOS ENERGÉTICOS     #");
        System.out.println("#                                        #");
        System.out.println("#                                        #");
        System.out.println("##########################################");
        System.out.println("Bem-vindo!");
        System.out.println("Pressione Enter para começar!");
    }

     public void printMessage(String message){
        out.printMessage(message);

    }

    public void printline(String s){
        out.printline(s);
    }

    public void printOpInvalida(){
        out.printOpInvalida();
    }
    public void printNextSimulation(){
        out.printNextSimulation();
    }


    public void printMainMenu(){
        out.printMenus((new String[]{"Casa que mais gastou", //1
                                     "Fornecedor com maior volume de faturação", // 2
                                     "Listar as faturas emitidas por um fornecedor", // 3
                                     "Listar os maiores consumidor de energia durante um periodo", // 4
                                     "Mudar o fornecedor de alguma casa", // 5
                                     "Ligar/Desligar os dispositivos de alguma divisão de alguma casa", // 6
                                     "Alterar os valores de algum fornecedor" // 7
                                     }),
                                     "MENU PRINCIPAL",0);
    }


    public void printMenuTurnOffON() {
        out.printMenus((new String[]{"Ligar", "Desligar"}),"MENU LIGAR E DESLIGAR DISPOSITIVO", 1);
    }

    public void printMenuTurnDivisionDevice() {
        out.printMenus((new String[]{"Divisão", "Dispositivo"}),"LIGAR/DESLIGAR DIVISÃO OU DISPOSITIVO", 1);
    }

    public void printMaisGastadora(SmartHouse g){
        ap.printMaisGastadora(g);
    }

    public void printCustosEGastos(Fatura last){
        ap.printCustosEGastos(last);
    }

    public void printFaturasEmitidas(List<Fatura> faturas){
        ap.printFaturasEmitidas(faturas);
    }

    public void printComercializadorMaisFaturacao(Comercializador c, Double volume){
        ap.printComercializadorMaisFaturacao(c,volume);
    }

    public void printDevicesDivisao(List<SmartDevice> listSD){
        ap.printDevicesDivisao(listSD);
    }

    public void printMaiorConsumidorTempo(SmartHouse c, LocalDate inicio, LocalDate fim){
        ap.printMaiorConsumidorTempo(c, inicio, fim);
    }



}

