package src;


import src.Controller.Interpretador;
import src.Files.LinhaIncorretaException;
import src.Files.Parser;
import src.Model.Casas.GestorComunidade;
import src.View.ApresentacaoMain;

import java.io.Serializable;

public class GestorConsumoAPP implements Serializable {

    public static void main(String[] args) {

        GestorComunidade gc = new GestorComunidade();   // Model
        Interpretador i;                                // Controlador
        ApresentacaoMain a = new ApresentacaoMain();    // View
        Parser parser = new Parser();                   // Parser


        try {
            parser.parse(gc);
        } catch (LinhaIncorretaException e) {
            a.printMessage("Wrong Format for Input File");
        }



        try{
            i = new Interpretador(a,gc);
            i.interpretador();
        }
        catch (Exception e){
            e.printStackTrace();
        }


        /*

        gc.ligarAleatorio();

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate inicio = LocalDate.now();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Pressione Enter para começar!");
        scanner.nextLine();

        System.out.println("A simulação encontra-se no dia de hoje (" + inicio.format(dateFormat) + ").\nDetermine o avançar do tempo com o padrão dia/mês/ano!");
        String dia = scanner.nextLine();
        LocalDate fim = LocalDate.parse(dia, dateFormat);



        gc.addFaturas(inicio, fim);

        inicio = fim;



        while (true) {
            List<Consumer<String>> methodList = new ArrayList<>();
            int input = -1;
            while (input != 0) {
                System.out.println("Se desejar saber qual a casa que mais gastou pressione 1");
                System.out.println("Se desejar saber qual o comercializador com maior volume de faturação pressione 2");
                System.out.println("Se desejar listar as faturas emitidas por um comercializador pressione 3");
                System.out.println("Se desejar listar os maiores consumidor de energia durante um periodo pressione 4");
                System.out.println("Se desejar mudar o fornecedor de algumas casa pressione 5");
                System.out.println("Se desejar ligar/desligar os devices de alguma divisão de alguma casa pressione 6");
                System.out.println("Se desejar alterar os valores de algum comerciante pressione 7");
                System.out.println("Se desejar continuar a simulação pressione 0");
                System.out.println("Se desejar terminar a simulação pressione 9");
                input = scanner.nextInt();


                switch (input) {
                    case 1 -> {
                        System.out.println("A casa que gastou mais foi: " + gc.maisGastadora());
                        Fatura last = gc.maisGastadora().getFaturas().get(gc.maisGastadora().getFaturas().size()-1);
                        System.out.println("A casa consumiu " + last.getConsumo() + " Joules e gastou " + last.getCustos_consumo() + "€ em energia" +
                        " e na " + last.getCustos_instalacao() + "€ na instalação.");
                    }
                    case 2 -> {
                        System.out.println();
                    }
                    case 3 -> {
                        System.out.println("Escolha o comercializador para ver as faturas emitidas!");
                        String fornecedor_faturas = scanner.nextLine();
                        System.out.println(gc.faturasComercializador(fornecedor_faturas));
                    }
                    case 4 -> {

                    }
                    case 5 -> {
                        System.out.println("Escolha o NIF da casa cujo fornecedor quer mudar");
                        int NIF_casa = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Escolha o novo fornecedor da casa " + NIF_casa);
                        scanner.nextLine();
                        String fornecedor_new = scanner.nextLine();
                        methodList.add(p -> gc.mudarFornecedorCasa(NIF_casa, fornecedor_new));
                    }
                    case 6 -> {
                        System.out.println("Pressione 1 se quiser ligar e 2 se quiser desligar");
                        int ligar_desligar = scanner.nextInt();
                        scanner.nextLine();
                        if (ligar_desligar == 1) {
                            System.out.println("Escolha o NIF da casa");
                            int NIF_casa = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Escolha a divisão");
                            String divisao = scanner.nextLine();
                            methodList.add (p-> gc.ligarDevicesDivisaoCasa(NIF_casa, divisao));
                        }
                        else if (ligar_desligar == 2) {
                            System.out.println("Escolha o NIF da casa");
                            int NIF_casa = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Escolha a divisão");
                            String divisao = scanner.nextLine();
                            methodList.add(p -> gc.desligarDevicesDivisaoCasa(NIF_casa, divisao));
                        } else {
                            System.out.println("Opção não disponível!");
                        }
                    }
                    case 7 -> {
                        System.out.println("Escolha comerciante para alterar valores");
                        String comerciante = scanner.nextLine();
                        Comercializador c;
                        c = gc.getComercializadores().get(comerciante);
                        if (c instanceof Comercializador1) {
                            System.out.println("Selecione novo valor para o desconto do comerciante");
                            double desconto_new = scanner.nextDouble();
                            scanner.nextLine();
                            methodList.add(p -> gc.mudarValoresComerciante(comerciante, desconto_new, 1));
                        } else {
                            System.out.println("Selecione valor para o maior e menor desconto");
                            double desconto_maior_new = scanner.nextDouble();
                            double desconto_menor_new = scanner.nextDouble();
                            scanner.nextLine();
                            methodList.add(p -> gc.mudarValoresComerciante(comerciante, desconto_maior_new, desconto_menor_new));
                        }
                    }
                    case 0 -> {
                        System.out.println("A simulação encontra-se no dia " + inicio.format(dateFormat) + ".\nDetermine o avançar do tempo com o padrão dia/mês/ano!");
                        scanner.nextLine();
                        dia = scanner.nextLine();
                        fim = LocalDate.parse(dia, dateFormat);
                        gc.addFaturas(inicio, fim);
                        inicio = fim;
                        for (Consumer<String> method : methodList){
                            method.accept(null);
                        }
                    }
                    case 9 -> {
                        System.out.println("Programa terminado!");
                        System.exit(0);
                    }
                    default -> {
                        System.out.println("Opção inválida");
                    }
                }
            }



        }

         */


    }




}
