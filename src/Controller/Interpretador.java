package src.Controller;

import src.Model.Casas.GestorComunidade;
import src.Model.Comercializadores.Comercializador;
import src.Model.Comercializadores.Comercializador1;
import src.Model.Fatura.Fatura;
import src.View.ApresentacaoMain;


import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;

public class Interpretador implements InterfaceInterpretador {
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

    public void interpretador() throws ClassNotFoundException, IOException{
        int input;
        List<Consumer<String>> methodList = new ArrayList<>();
        gc.ligarAleatorio();

        ap.welcome();
        in.readline();

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate inicio = LocalDate.now();

        ap.printMessage("A simulação encontra-se no dia de hoje (" + inicio.format(dateFormat) + ").");
        ap.printMessage("Determine o avançar do tempo com o padrão dia/mês/ano!");

        LocalDate fim = in.readLocalDate();
        gc.addFaturas(inicio, fim);
        inicio = fim;

        while (true){
            ap.printMainMenu();
            ap.printline("Escolha a sua opção:");
            input = in.readInt();

            switch (input) {
                case 1 -> {
                    ap.printMaisGastadora(gc.maisGastadora());
                    Fatura last = gc.maisGastadora().getFaturas().get(gc.maisGastadora().getFaturas().size()-1);
                    ap.printCustosEGastos(last);
                }
                case 2 -> {
                    Comercializador c = gc.maisFaturacao();
                    ap.printComercializadorMaisFaturacao(c,gc.volumeFaturacao(c));
                }
                case 3 -> {
                    ap.printMessage("Escolha o fornecedor para ver as faturas emitidas!");
                    String fornecedor_faturas = in.readline();
                    ap.printFaturasEmitidas(gc.faturasComercializador(fornecedor_faturas));
                }
                case 4 -> {
                    ap.printMessage("Escolha a data inicial das faturas!");
                    LocalDate inicio_fatura = in.readLocalDate();
                    ap.printMessage("Escolha a data final das faturas!");
                    LocalDate fim_fatura = in.readLocalDate();
                    ap.printMaiorConsumidorTempo(gc.getMaxConsumidorTempo(inicio_fatura,fim_fatura),inicio_fatura,fim_fatura);
                }
                case 5 -> {
                    ap.printMessage("Escolha o NIF da casa cujo fornecedor quer mudar");
                    int NIF_casa = in.readInt();
                    ap.printMessage("Escolha o novo fornecedor da casa " + NIF_casa);
                    String fornecedor_new = in.readline();
                    methodList.add(p -> gc.mudarFornecedorCasa(NIF_casa, fornecedor_new));
                    ap.printNextSimulation();
                }
                case 6 -> {
                    ap.printMenuTurnOffON();
                    int ligar_desligar = in.readInt();
                    ap.printMenuTurnDivisionDevice();
                    int divisao_device = in.readInt();
                    if (ligar_desligar == 1) {
                        ap.printMessage("Escolha o NIF da casa");
                        int NIF_casa = in.readInt();
                        ap.printMessage("Escolha a divisão");
                        String divisao = in.readline();
                        if (divisao_device == 1) {
                            methodList.add(p -> gc.ligarDevicesDivisaoCasa(NIF_casa, divisao));
                            ap.printNextSimulation();
                        }
                        else if (divisao_device == 2){
                            ap.printDevicesDivisao(gc.getCasa(NIF_casa).getdevicesDivision(divisao));
                            ap.printMessage("Escolha o id do dispositivo que quer ligar.");
                            UUID id = UUID.fromString(in.readline());
                            gc.ligarDeviceCasa(NIF_casa,id);
                            ap.printNextSimulation();

                        }
                        else {
                            ap.printOpInvalida();
                        }
                    }
                    else if (ligar_desligar == 2) {
                        ap.printMessage("Escolha o NIF da casa");
                        int NIF_casa = in.readInt();
                        ap.printMessage("Escolha a divisão");
                        String divisao = in.readline();
                        if (divisao_device == 1) {
                            methodList.add(p -> gc.desligarDevicesDivisaoCasa(NIF_casa, divisao));
                            ap.printNextSimulation();
                        }
                        else if (divisao_device == 2){
                            ap.printDevicesDivisao(gc.getCasa(NIF_casa).getdevicesDivision(divisao));
                            ap.printMessage("Escolha o id do dispositivo que quer desligar.");
                            UUID id = UUID.fromString(in.readline());
                            gc.desligarDeviceCasa(NIF_casa,id);
                            ap.printNextSimulation();
                        }
                        else {
                            ap.printOpInvalida();
                        }
                    } else {
                       ap.printOpInvalida();
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
                        methodList.add(p -> gc.mudarValoresComerciante(comerciante, desconto_new, 1));
                        ap.printNextSimulation();
                    } else {
                        ap.printMessage("Selecione valor para o maior desconto");
                        double desconto_maior_new = in.readDouble();
                        ap.printMessage("Selecione valor para o menor desconto");
                        double desconto_menor_new = in.readDouble();
                        methodList.add(p -> gc.mudarValoresComerciante(comerciante, desconto_maior_new, desconto_menor_new));
                        ap.printNextSimulation();
                    }
                }
                case 0 -> {
                    ap.printMessage("A simulação encontra-se no dia " + inicio.format(dateFormat) + ".\n");
                    ap.printMessage("Determine o avançar do tempo com o padrão dia/mês/ano!\n");
                    fim = in.readLocalDate();
                    gc.addFaturas(inicio, fim);
                    inicio = fim;
                    if (!methodList.isEmpty()) {
                        for (Consumer<String> method : methodList) {
                            method.accept(null);
                        }
                        ap.printMessage("As alterações foram executadas!");
                        methodList.clear();
                    }
                }
                case 9 -> {
                    ap.printMessage("Programa terminado!");
                    in.close();
                }
                default -> {
                    ap.printOpInvalida();
                }
            }
        }
    }


}
