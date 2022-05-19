package src.Model.Casas;

import src.Model.SmartDevice.SmartDevice;

import java.util.HashMap;
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

    public boolean equals(Object o){
        if(this == o)
            return true;
        if((o == null) || (this.getClass() != o.getClass()))
            return false;
        Object g = (GestorComunidade) o;
        return casas.equals(g);
    }

    public String toString(){
        return "Comunidade{ " + casas.toString();
    }

    public GestorComunidade clone(){
        return new GestorComunidade(this);
    }

    public Map<Integer, SmartHouse> getCasas(){
        Map<Integer, SmartHouse> casas = new HashMap<>();
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



    public void addCasa(SmartHouse casa){
        casas.put(casa.getNIF(),casa);
    }

    public void removeCasa(SmartHouse casa){
        casas.remove(casa.getNIF());
    }

    public SmartHouse getCasa(int NIF){
        return casas.get(NIF).clone();
    }

    public Map<Integer,Double> consumidoPorCasa(){
        return casas.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, val -> val.getValue().consumoTotalCasaDiario()));
    }

    public Map<Integer,Double> custoPorCasa(){
        return casas.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, val -> val.getValue().custoTotalCasaDiario()));
    }

    public Map<Integer,Double> custoInstalacaoPorCasa(){
        return casas.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, val -> val.getValue().getCustos_instalacao()));
    }



}
