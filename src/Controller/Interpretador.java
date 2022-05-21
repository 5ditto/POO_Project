package src.Controller;

import src.Files.SaveLoadState;
import src.Model.Casas.GestorComunidade;
import src.Model.Comercializadores.Comercializador;
import src.Model.Comercializadores.Comercializador1;
import src.Model.Fatura.Fatura;
import src.View.Apresentacao;


import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Consumer;

public class Interpretador implements InterfaceInterpretador {
    private final Input in;// Leitura de Input do utilizador
    Apresentacao ap;
    GestorComunidade gc;

    /*
        Construtor
     */
    public Interpretador(Apresentacao a, GestorComunidade g) {
        in = new Input();
        ap = a;
        gc = g;
    }

    public void interpretador() throws ClassNotFoundException, IOException {


        ap.welcome();
        in.readline();

        int startMenu = this.startMenu();
        if (startMenu == -1) return;
        if (startMenu == 1) interpretadorMenuPrincipal();
    }

    public void interpretadorMenuPrincipal() {

        List<Consumer<String>> methodList = new ArrayList<>();

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate inicio = LocalDate.now();

        gc.ligarAleatorio();
        ap.printMessage("A simulação encontra-se no dia de hoje (" + inicio.format(dateFormat) + ").");
        ap.printMessage("Determine o avançar do tempo com o padrão dia/mês/ano!");
        LocalDate fim = in.readLocalDate();
        while (fim.isBefore(inicio)) {
            ap.printMessage("A data têm de ser posterior à data atual (" + inicio.format(dateFormat) + ").");
            fim = in.readLocalDate();
        }
        gc.addFaturas(inicio, fim);
        inicio = fim;

        while (true) {
            ap.printMainMenu();
            ap.printline("Escolha a sua opção:");
            int input = in.readInt();

            switch (input) {
                case 1 -> {
                    ap.printMessage("Introduz o nome do save: ");
                    String file = in.readline();
                    int i = SaveLoadState.saveDados("equemano.txt", gc);
                    if (i == 0)
                        ap.printMessage("Dados guardados com sucesso!");
                    else
                        ap.printMessage("Erro ao guardar dados!");
                }
                case 2 -> {
                    interpretadorConsultas();
                }
                case 3 -> {
                    interpretadorAlteracoes(methodList);
                }
                case 4 -> {
                    interpretadorDados();
                }
                case 0 -> {
                    ap.printMessage("A simulação encontra-se no dia " + inicio.format(dateFormat) + ".\n");
                    ap.printMessage("Determine o avançar do tempo com o padrão dia/mês/ano!\n");
                    fim = in.readLocalDate();
                    while (fim.isBefore(inicio)) {
                        ap.printline("A data têm de ser posterior à data atual (" + inicio.format(dateFormat) + ").");
                        fim = in.readLocalDate();
                    }
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

    private int startMenu() {
        ap.printMenuInicial();
        ap.printMessage("Opção:");
        int choice = in.readInt();
        switch (choice) {
            case 1:
                ap.printMessage("Introduza o nome do save:");
                String file_name = in.readline();
                try {
                    gc = SaveLoadState.loadDados(file_name);
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
                return 0;
            case 2:
                ap.printMessage("Inicializando a simulação!");
                return 1;
            case 3:
                return -1;
            default:
                ap.printMessage("Opção inválida!");
                return this.startMenu();
        }
    }


    public void interpretadorConsultas() {
        ap.printMenuConsultas();
        ap.printline("Escolha a sua opção:");
        int input = in.readInt();

        switch (input) {
            case 1 -> {
                ap.printMaisGastadora(gc.maisGastadora());
                Fatura last = gc.maisGastadora().getFaturas().get(gc.maisGastadora().getFaturas().size() - 1);
                ap.printCustosEGastos(last);
            }

            case 2 -> {
                Comercializador c = gc.maisFaturacao();
                ap.printComercializadorMaisFaturacao(c, gc.volumeFaturacao(c));
            }

            case 3 -> {
                ap.printMessage("Escolha o comercializador para ver as faturas emitidas por este!");
                String fornecedor_faturas = in.readline();
                ap.printFaturasEmitidas(gc.faturasComercializador(fornecedor_faturas));
            }

            case 4 -> {
                ap.printMessage("Escolha a data inicial da emissão das faturas!");
                LocalDate inicio_fatura = in.readLocalDate();
                ap.printMessage("Escolha a data final das emissão faturas!");
                LocalDate fim_fatura = in.readLocalDate();
                ap.printMessage("Escolha o tamanho da lista dos maiores consumidores!");
                int numero_consumidores = in.readInt();
                ap.printMaiorConsumidorTempo(gc.getMaxConsumidorTempo(inicio_fatura, fim_fatura), inicio_fatura, fim_fatura, numero_consumidores);
            }

            default -> {
                ap.printOpInvalida();
            }

        }
    }

    public void interpretadorAlteracoes(List<Consumer<String>> methodList) {
        ap.printMenuAlteracoes();
        ap.printline("Escolha a sua opção:");
        int input = in.readInt();

        switch (input) {
            case 1 -> {
                ap.printMessage("Casas existentes na vizinhança:");
                ap.printCasas(gc);
                ap.printMessage("Escolha o NIF da casa cujo comercializante quer mudar!");
                int NIF_casa = in.readInt();
                ap.printMessage("Fornecedores existentes na vizinhança:");
                ap.printComercializadores(gc);
                ap.printMessage("Escolha o novo fornecedor da casa " + NIF_casa + '!');
                String fornecedor_new = in.readline();
                methodList.add(p -> gc.mudarFornecedorCasa(NIF_casa, fornecedor_new));
                ap.printNextSimulation();
            }

            case 2 -> {
                ap.printMenuTurnOffON();
                int ligar_desligar = in.readInt();
                ap.printMenuTurnDivisionDevice();
                int divisao_device = in.readInt();
                ap.printMessage("Casas existentes na vizinhança:");
                ap.printCasas(gc);
                if (ligar_desligar == 1) {
                    ap.printMessage("Escolha o NIF da casa!");
                    int NIF_casa = in.readInt();
                    ap.printMessage("Divisões da casa:");
                    ap.printDivisoes(gc.getCasa(NIF_casa));
                    ap.printMessage("Escolha a divisão!");
                    String divisao = in.readline();
                    if (divisao_device == 1) {
                        methodList.add(p -> gc.ligarDevicesDivisaoCasa(NIF_casa, divisao));
                        ap.printNextSimulation();
                    } else if (divisao_device == 2) {
                        ap.printMessage("Devices da divisão:");
                        ap.printDevicesDivisao(gc.getCasa(NIF_casa), divisao);
                        ap.printMessage("Escolha o id do dispositivo que quer ligar!");
                        UUID id = UUID.fromString(in.readline());
                        gc.ligarDeviceCasa(NIF_casa, id);
                        ap.printNextSimulation();

                    } else {
                        ap.printOpInvalida();
                    }
                } else if (ligar_desligar == 2) {
                    ap.printMessage("Escolha o NIF da casa!");
                    int NIF_casa = in.readInt();
                    ap.printMessage("Divisões da casa:");
                    ap.printDivisoes(gc.getCasa(NIF_casa));
                    ap.printMessage("Escolha a divisão!");
                    String divisao = in.readline();
                    if (divisao_device == 1) {
                        methodList.add(p -> gc.desligarDevicesDivisaoCasa(NIF_casa, divisao));
                        ap.printNextSimulation();
                    } else if (divisao_device == 2) {
                        ap.printMessage("Devices da divisão:");
                        ap.printDevicesDivisao(gc.getCasa(NIF_casa), divisao);
                        ap.printMessage("Escolha o id do dispositivo que quer desligar.");
                        UUID id = UUID.fromString(in.readline());
                        gc.desligarDeviceCasa(NIF_casa, id);
                        ap.printNextSimulation();
                    } else {
                        ap.printOpInvalida();
                    }
                } else {
                    ap.printOpInvalida();
                }
            }


            case 3 -> {
                ap.printMessage("Fornecedores existentes na vizinhança:");
                ap.printComercializadores(gc);
                ap.printMessage("Escolha comerciante para alterar os seus valores!");
                String comerciante = in.readline();
                Comercializador c;
                c = gc.getComercializadores().get(comerciante);
                if (c instanceof Comercializador1) {
                    ap.printMessage("Selecione novo valor para o desconto do comerciante!");
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

            default -> {
                ap.printOpInvalida();
            }
        }
    }

    public void interpretadorDados() {
        ap.printMenuDados();
        ap.printline("Escolha a sua opção:");
        int input = in.readInt();

        switch (input) {
            case 1 ->{
                //ver casas
                ap.printCasas(gc);
            }
            case 2 -> {
                //ver casa
                ap.printCasas(gc);
                ap.printMessage("Escolha o NIF da casa!");
                int NIF_casa = in.readInt();
                ap.printDivisoes(gc.getCasa(NIF_casa));
            }
            case 3 -> {
                // ver casas na vizinhança e dispositivos
                ap.printCasas(gc);
                ap.printMessage("Escolha o NIF da casa!");
                int NIF_casa = in.readInt();
                ap.printDivisoes(gc.getCasa(NIF_casa));
                ap.printMessage("Escolha a divisão da casa!");
                String divisao = in.readline();
                ap.printDevicesDivisao(gc.getCasa(NIF_casa),divisao);
            }
            case 4 ->{
                // faturas
                ap.printCasas(gc);
                ap.printMessage("Escolha o NIF da casa!");
                int NIF_casa = in.readInt();
                ap.printDivisoes(gc.getCasa(NIF_casa));
                ap.printFaturasEmitidas(gc.getCasa(NIF_casa).getFaturas());
            }
            case 5 -> {
                // ver casas na vizinhança, casa em particular e ultimo consumo
                ap.printCasas(gc);
                ap.printMessage("Escolha o NIF da casa!");
                int NIF_casa = in.readInt();
                ap.printUltimoConsumoECusto(gc.getCasa(NIF_casa));
            }
            case 6 -> {
                ap.printComercializadores(gc);
            }
            default -> {
                ap.printOpInvalida();
            }
        }
    }



}
