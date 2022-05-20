package src.Controller;

import src.Model.Casas.GestorComunidade;
import src.Model.Fatura;
import src.View.ApresentacaoMain;
import src.Model.*;

import java.io.IOException;
import java.util.Scanner;

public class Interpretador {
    private final Input in;// Leitura de Input do utilizador
    ApresentacaoMain ap;
    GestorComunidade gc;
    /*
        Construtor
     */
    public Interpretador(ApresentacaoMain a, GestorComunidade g) {
        in = new Input();
        ap = a;
        gc = g;
    }

    private void interpretador(ApresentacaoMain a){
        ap.welcome();
        in.readline();
        a.clearScreen();
        Scanner scanner = new Scanner(System.in);
        a.printMessage("Pressione Enter para começar");
        scanner.nextLine();

        int input;

        while (true){
            a.printMainMenu();
            a.printline("Escolha a sua opção:");
            input = in.readInt();

            switch (input) {
                case 1 -> {

                }
                case 2 -> {

                }
                case 3 -> {

                }
                case 4 -> {

                }
                case 9 -> {
                    a.printSimulationMenu();

                    //int input_simul = scanner.nextInt();
                    int input_simul = in.readInt();
                    switch (input_simul) {
                        case 1 -> {
                            a.printMaisGastadora(gc.maisGastadora());
                        }
                        case 2 -> {

                        }
                        case 3 -> {

                        }
                        case 9 -> {

                        }
                        default -> {
                           a.printMessage("Opção inválida");
                        }
                    }
                }

                case 0 -> {
                    a.printMessage("Programa terminado!");
                    System.exit(0);
                }
                default -> {
                    a.printline("Opção inválida");
                }
            }
        }
    }


}
