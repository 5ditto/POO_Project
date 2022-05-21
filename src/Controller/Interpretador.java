package src.Controller;

import src.Model.Casas.GestorComunidade;
import src.Model.Comercializadores.Comercializador;
import src.Model.Comercializadores.Comercializador1;
import src.View.ApresentacaoMain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

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
    public void interpretador(){
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate inicio = LocalDate.now();
        int input;
        List<Consumer<String>> methodList = new ArrayList<>();
        gc.ligarAleatorio();

        ap.welcome();
        in.readline();

        ap.printMessage("A simulação encontra-se no dia de hoje (" + inicio.format(dateFormat) + ").");
        ap.printMessage("Determine o avançar do tempo com o padrão dia/mês/ano!");
        String dia = in.readline();
        LocalDate fim = LocalDate.parse(dia, dateFormat);

        inicio = fim;
        while (true){
            ap.printMainMenu();
            ap.printline("Escolha a sua opção:");
            input = in.readInt();

            switch (input) {
                case 1 -> {
                    ap.printMaisGastadora(gc.maisGastadora());
                }
                case 2 -> {

                }
                case 3 -> {
                    ap.printMessage("Escolha o comercializador para ver as faturas emitidas!");
                    String fornecedor_faturas = in.readline();
                    ap.printFaturasEMitidas(gc.faturasComercializador(fornecedor_faturas));
                }
                case 4 -> {

                }
                case 5 -> {
                    ap.printMessage("Escolha o NIF da casa cujo fornecedor quer mudar");
                    int NIF_casa = in.readInt();
                    in.readline();
                    ap.printMessage("Escolha o novo fornecedor da casa " + NIF_casa);
                    in.readline();
                    String fornecedor_new = in.readline();
                    methodList.add(p -> gc.mudarFornecedorCasa(NIF_casa, fornecedor_new));
                }
                case 6 -> {
                    ap.printMenuTurnOffON();
                    int ligar_desligar = in.readInt();
                    in.readline();
                    if (ligar_desligar == 1) {
                        ap.printMessage("Escolha o NIF da casa");
                        int NIF_casa = in.readInt();
                        in.readline();
                        ap.printMessage("Escolha a divisão");
                        String divisao = in.readline();
                        methodList.add (p-> gc.ligarDevicesDivisaoCasa(NIF_casa, divisao));
                    }
                    else if (ligar_desligar == 2) {
                        ap.printMessage("Escolha o NIF da casa");
                        int NIF_casa = in.readInt();
                        in.readline();
                        ap.printMessage("Escolha a divisão");
                        String divisao = in.readline();
                        methodList.add(p -> gc.desligarDevicesDivisaoCasa(NIF_casa, divisao));
                    } else {
                       ap.printMessage("Opção não disponível!");
                    }
                }
                case 7 -> {
                    ap.printMessage("Escolha comerciante para alterar valores");
                    String comerciante = in.readline();
                    Comercializador c;
                    c = gc.getComercializadores().get(comerciante);
                    if (c instanceof Comercializador1) {
                        ap.printMessage("Selecione novo valor para o desconto do comerciante");
                        double desconto_new = in.readDouble();
                        in.readline();
                        methodList.add(p -> gc.mudarValoresComerciante(comerciante, desconto_new, 1));
                    } else {
                        ap.printMessage("Selecione valor para o maior e menor desconto");
                        double desconto_maior_new = in.readDouble();
                        double desconto_menor_new = in.readDouble();
                        in.readline();
                        methodList.add(p -> gc.mudarValoresComerciante(comerciante, desconto_maior_new, desconto_menor_new));
                    }
                }
                case 0 -> {
                    ap.printMessage("A simulação encontra-se no dia " + inicio.format(dateFormat) + ".\n");
                    ap.printMessage("Determine o avançar do tempo com o padrão dia/mês/ano!");
                    in.readline();
                    dia = in.readline();
                    fim = LocalDate.parse(dia, dateFormat);
                    gc.addFaturas(inicio, fim);
                    inicio = fim;
                    for (Consumer<String> method : methodList) {
                        method.accept(null);
                    }
                }

                case 9 -> {
                    ap.printMessage("Programa terminado!");
                    System.exit(0);
                }
                default -> {
                    ap.printline("Opção inválida");
                }
            }
        }
    }


}
