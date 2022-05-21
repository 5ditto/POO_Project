package src.View;

import src.Model.Casas.SmartHouse;
import src.Model.Comercializadores.Comercializador;
import src.Model.Fatura.Fatura;
import src.Model.SmartDevice.SmartDevice;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class Apresentacao {

    public void printMaisGastadora(SmartHouse gastadora) {
        System.out.print("A casa que gastou mais foi: " + gastadora);
    }

    public void printCustosEGastos(Fatura last) {
        System.out.println("A casa consumiu " + last.getConsumo() + " Joules e gastou " + last.getCustos_consumo() + "€ em energia" +
                " e na " + last.getCustos_instalacao() + "€ na instalação.");
    }

    public void printFaturasEmitidas(List<Fatura> listaFaturas) {
        System.out.println(listaFaturas);
    }

    public void printComercializadorMaisFaturacao(Comercializador c, Double volume) {
        System.out.println("O comercializador com maior volume de faturação é: " + c + " com um volume de faturação total de " + volume
                + "€");
    }

    public void printDevicesDivisao(List<SmartDevice> listSD) {
        System.out.println("Os dispositivos desta divisão são: " + listSD);
    }

    public void printMaiorConsumidorTempo(Set<SmartHouse> c, LocalDate inicio, LocalDate fim) {
        System.out.println("Os maiores consumidores no período de tempo de " + inicio + " a " + fim + " são: ");
        int counter = 0;
        for (SmartHouse h : c) {
            System.out.println("O consumidor número " + counter + ", com um consumo de " + h.volumeFaturaEntreDatas(inicio, fim) + " Joules, é " + h);
            counter++;
        }
    }


}

