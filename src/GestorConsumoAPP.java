package src;


import src.Controller.Interpretador;
import src.Files.LinhaIncorretaException;
import src.Files.Parser;
import src.Model.Casas.GestorComunidade;
import src.View.ApresentacaoMain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class GestorConsumoAPP implements Serializable {

    public static void main(String[] args){

        GestorComunidade gc     = new GestorComunidade();   // Model
        Interpretador    i;                                 // Controlador
        ApresentacaoMain a      = new ApresentacaoMain();   // View
        Parser           parser = new Parser();             // Parser


        try{
            parser.parse(gc);
        } catch (LinhaIncorretaException e) {
            a.printMessage("Wrong Format for Input File");
        }

        /*
        try{
            i = new Interpretador(a,gc);
        }
        catch (Exception e){
            e.printStackTrace();
        }

         */

        gc.ligarAleatorio();

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("d/M/yyyy");
        LocalDate inicio = LocalDate.now();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Pressione Enter para começar");
        scanner.nextLine();

        System.out.println("A simulação encontra-se no dia de hoje (" + inicio.format(dateFormat) + ").\n Determine o avançar do tempo com o padrão dia/mês/ano!");
        String dia = scanner.nextLine();
        LocalDate fim = LocalDate.parse(dia, dateFormat);


        gc.addFaturas(inicio, fim);

        inicio = fim;

        int input;

        while (true) {
            System.out.println("Se desejar saber qual a casa que mais gastou pressione 1");
            System.out.println("Se desejar saber qual o comercializador com maior volume de faturação pressione 2");
            System.out.println("Se desejar listar as faturas emitidas por um comercializador pressione 3");
            System.out.println("Se desejar listar os maiores consumidor de energia durante um periodo pressione 4");
            System.out.println("Se desejar continuar a simulação pressione 0");
            System.out.println("Se desejar terminar a simulação pressione 9");

            input = scanner.nextInt();

            switch (input){
                case 1 ->{
                    System.out.println("A casa que gastou mais foi: " + gc.maisGastadora());
                }
                case 2 ->{

                }
                case 3 ->{

                }
                case 4 ->{

                }
                case 0 ->{
                    System.out.println("Se desejar mudar o fornecedor de algumas casa pressione 1");
                    System.out.println("Se desejar desligar os devices de alguma divisão de alguma casa pressione 2");
                    System.out.println("Se desejar alterar os valores de algum comerciante pressione 3");
                    System.out.println("Se desejar continuar a simulação pressione 9");
                    int input_simul = scanner.nextInt();

                    switch (input_simul){
                        case 1 ->{

                        }
                        case 2 ->{

                        }
                        case 3 ->{

                        }
                        case 9 ->{

                        }
                        default -> {
                            System.out.println("Opção inválida");
                        }
                    }
                }

                case 9 ->{
                    System.out.println("Programa terminado!");
                    System.exit(0);
                }
                default -> {
                    System.out.println("Opção inválida");
                }


            }

        }










    }


}
