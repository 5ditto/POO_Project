package src.View;

import src.Model.Casas.SmartHouse;

import java.util.Map;

public class ApresentacaoMain {
    private final Output out; //Imprime os outputs
    private Apresentacao ap; // Apresentação responsável pelos outputs relacionados os resultados


    public ApresentacaoMain(){
        out = new Output();
        ap  = new Apresentacao();
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
        System.out.println("Pressione uma tecla para começar!");
    }

    /*
        Apresenta uma mensagem
     */
    public void printMessage(String message){
        Output.clearScreen();
        out.printMessage(message);

    }

    public void printSHouse(SmartHouse l){}

    public void printOption(Map<Integer,String> menu){
        out.printMessage("");
        for(Map.Entry<Integer,String> entry : menu.entrySet()){
            System.out.println(entry.getKey()+". ");
        }
    }

    public void printline(String s){
        out.printline(s);
    }

    public void printMainMenu(){
        out.printMenus((new String[]{"Casa que mais gastou", //1
                                     "Comercializador com maior volume de faturação", // 2
                                     "Listar as faturas emitidas por um comercializador", // 3
                                     "Listar os maiores consumidor de energia durante um periodo", // 4
                                     "Continuar a simulação", // 0
                                     "Terminar a simulação"}), // 9
                                     "MENU PRINCIPAL",0);
    }


    public void printSimulationMenu(){
        out.printMenus((new String[]{"Mudar o fornecedor de algumas casa",
                                     "Desligar os dispositivos de alguma divisão de alguma casa",
                                     "Alterar os valores de algum comerciante",
                                     "Continuar a simulaçã"}), "MENU SIMULAÇÃO",1);
    }

    public void printMaisGastadora(SmartHouse g){
        ap.printMaisGastadora(g);
    }

    public void clearScreen(){
        Output.clearScreen();
    }

}

