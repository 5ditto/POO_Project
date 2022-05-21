package src.View;

import src.Model.Casas.GestorComunidade;
import src.Model.Casas.SmartHouse;
import src.Model.Comercializadores.Comercializador;
import src.Model.Fatura.Fatura;
import src.Model.SmartDevice.SmartDevice;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

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


    public void printMenuConsultas(){
        out.printMenus((new String[]{"Casa que mais gastou no último período", //1
                                     "Fornecedor com maior volume de faturação", // 2
                                     "Listar as faturas emitidas por um fornecedor", // 3
                                     "Listar os maiores consumidores de energia durante um periodo"}),  // 4
                                     "MENU CONSULTAS",1);
    }

    public void printMenuAlteracoes(){
        out.printMenus((new String[]{"Mudar o fornecedor de alguma casa", // 1
                                     "Ligar/Desligar os dispositivos de alguma divisão de alguma casa", // 2
                                     "Alterar os valores de algum fornecedor" }), // 3
                                     "MENU ALTERAÇÕES",1);
    }
    public void printMainMenu(){
        out.printMenus((new String[]{"Dar save/load do estado do programa", //1
                                     "Consultar estatísticas da vizinhança", // 2
                                     "Fazer alterações nos dispositivos, fornecedores, casas",// 3
                                     "Visualizar dados do programa"}),
                                     "MENU PRINCIPAL",0);
    }

    public void printMenuInicial(){
        out.printMenus((new String[]{"Carregar Dados", // 1
                                     "Nova Simulação"}), // 2
                                     "MENU INICIAL", 2);
    }

    public void printMenuDados(){
        out.printMenus((new String[]{"Ver casas da visinhança",
                                     "Ver casas da vizinhança e casa particular",
                                     "Ver casas na vizinhança e ver casa em particular e ver faturas",
                                     "Ver casas na vizinhança, casa em particular e dispositivos de divisao",
                                     "Ver fornecedores"}),
                                     "Menu Visualizar Dados",1);
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

    public void printMaiorConsumidorTempo(List<SmartHouse> c, LocalDate inicio, LocalDate fim, int consumidor){
        ap.printMaiorConsumidorTempo(c, inicio, fim, consumidor);
    }

    public void printCasas(GestorComunidade gc){
        ap.printCasas(gc);
    }

    public void printComercializadores(GestorComunidade gc){
        ap.printComercializadores(gc);
    }

    public void printDivisoes(SmartHouse c){
        ap.printDivisoes(c);
    }

    public void printDevicesDivisao(SmartHouse c, String divisao){
        ap.printDevicesDivisao(c,divisao);
    }

}

