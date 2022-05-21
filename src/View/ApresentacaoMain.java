package src.View;

import src.Model.Casas.GestorComunidade;
import src.Model.Casas.SmartHouse;
import src.Model.Comercializadores.Comercializador;
import src.Model.Fatura.Fatura;
import src.Model.SmartDevice.SmartDevice;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

public class ApresentacaoMain {

    public void printMaisGastadora(SmartHouse gastadora){
        System.out.print("A casa que gastou mais foi: " + gastadora);
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

    public void printMaiorConsumidorTempo(Map<Double,SmartHouse> c, LocalDate inicio, LocalDate fim, int consumidor){
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Top " + consumidor + " consumidores no período de tempo de " + inicio.format(dateFormat) + " a " + fim.format(dateFormat) + '.');
        int counter = 1;
        for (SmartHouse sh : c.values()){
        System.out.println("O consumidor número " + counter + " é " + sh + " e consumiu " + sh.volumeFaturaEntreDatas(inicio,fim) + " Joules.");
        counter++;
        if (counter > consumidor) break;
        }
    }

    public void printCasas(GestorComunidade gc){
        System.out.println(gc.getCasas());
    }

    public void printComercializadores(GestorComunidade gc){
        System.out.println(gc.getComercializadores().values());
    }

    public void printDivisoes(SmartHouse c){
        System.out.println(c.getDivisions().keySet());
    }

    public void printDevicesDivisao(SmartHouse c, String divisao){
        System.out.println(c.getdevicesDivision(divisao));
    }

}

