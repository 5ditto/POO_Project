package src;

import src.SmartDevice.SmartBulb;
import src.SmartDevice.SmartDevice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class GestorComunidade {

    Map<Integer, SmartHouse> casas;

    public GestorComunidade(){
        casas = new HashMap<>();
    }

    public GestorComunidade(Map<Integer,SmartHouse> casas){
        this.setCasas(casas);
    }

    public GestorComunidade(GestorComunidade gestor){
        this.setCasas(gestor.getCasas());
    }

    public Map<Integer, SmartHouse> getCasas(){
        casas = new HashMap<>();
        for (SmartHouse h : this.casas.values()){
            int key = h.getNIF();
            casas.put(key,h.clone());
        }
        return casas;
    }

    public void setCasas(Map<Integer, SmartHouse> casas){
        this.casas = new HashMap<>();
        for (SmartHouse h : casas.values()){
            int key = h.getNIF();
            this.casas.put(key,h.clone());
        }
    }


    public Map<Integer,Double> consumidoPorCasa(int numeroDias){
        return casas.values().stream().collect(Collectors.toMap(SmartHouse::getNIF , c-> c.consumoTotalCasaDiario()*numeroDias);
    }







}
