package src.View;

import src.Model.Casas.SmartHouse;
import src.Model.Comercializadores.Comercializador;
import src.Model.Fatura.Fatura;
import src.Model.SmartDevice.SmartDevice;

import java.time.LocalDate;
import java.util.List;
<<<<<<< HEAD
import java.util.Map;
import java.util.Set;
=======
>>>>>>> 6c7e88e479ac55d27e525908f4bd8eea00b90d8d

public class ApresentacaoMain {

<<<<<<< HEAD
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
                                     "Comercializante com maior volume de faturação", // 2
                                     "Listar as faturas emitidas por um comercializante", // 3
                                     "Listar os maiores consumidores de energia durante um periodo", // 4
                                     "Mudar o comercializante duma casa", // 5
                                     "Ligar/Desligar os dispositivos duma casa", // 6
                                     "Alterar os valores de um comercializante" // 7
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
=======
    public void printMaisGastadora(SmartHouse gastadora){
        System.out.print("A casa que gastou mais foi: " + gastadora);
>>>>>>> 6c7e88e479ac55d27e525908f4bd8eea00b90d8d
    }

    public void printCustosEGastos(Fatura last){
        System.out.println("A casa consumiu " + last.getConsumo() + " Joules e gastou " + last.getCustos_consumo() + "€ em energia" +
                           " e na " + last.getCustos_instalacao() + "€ na instalação.");
    }

    public void printFaturasEmitidas(List<Fatura> listaFaturas){
        System.out.println(listaFaturas);
    }

    public void printComercializadorMaisFaturacao(Comercializador c, Double volume){
        System.out.println("O fornecedor com maior volume de faturação é o " + c + " com um volume de faturação total de " + volume
                           + "€");
    }

    public void printDevicesDivisao(List<SmartDevice> listSD){
        System.out.println("Os dispositivos desta divisão são " + listSD);
    }

<<<<<<< HEAD
    public void printMaiorConsumidorTempo(Set<SmartHouse> c, LocalDate inicio, LocalDate fim) {
        ap.printMaiorConsumidorTempo(c, inicio, fim);
    }


        public void clearScreen(){
        Output.clearScreen();
=======
    public void printMaiorConsumidorTempo(SmartHouse c, LocalDate inicio, LocalDate fim){
        System.out.println("O maior consumidor no período de tempo de " + inicio + " a " + fim + " é " + c);
>>>>>>> 6c7e88e479ac55d27e525908f4bd8eea00b90d8d
    }

}

