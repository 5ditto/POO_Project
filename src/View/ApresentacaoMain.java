package src.View;

import src.Model.Casas.SmartHouse;

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
        Output.clear();
        out.printMessage(message);

    }

    public void printSHouse(SmartHouse l){}
}

