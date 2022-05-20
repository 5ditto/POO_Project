package src.Model.Casas;

import src.Model.Comercializadores.Comercializadores;
import src.Model.Fatura;
import src.Model.SmartDevice.SmartDevice;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


public class GestorComunidade {

    Map<Integer, SmartHouse> casas;
    Map<String, Comercializadores> comercializadores;

    public GestorComunidade(){
        casas = new HashMap<>();
        comercializadores = new HashMap<>();
    }

    public GestorComunidade(Map<Integer,SmartHouse> casas, Map<String, Comercializadores> comercializadores){
        this.setCasas(casas);
        this.setComercializadores(comercializadores);
    }

    public GestorComunidade(GestorComunidade gestor){
        this.setCasas(gestor.getCasas());
        this.setComercializadores(gestor.getComercializadores());
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

    public Map<String, Comercializadores> getComercializadores(){
        Map<String, Comercializadores> comercializadores = new HashMap<>();
        for (Comercializadores c : this.comercializadores.values()){
            String key = c.getNome();
            comercializadores.put(key,c.clone());
        }
        return comercializadores;
    }

    public void setComercializadores(Map<String, Comercializadores> comercializadores){
        this.comercializadores = new HashMap<>();
        for (Comercializadores c : comercializadores.values()){
            String key = c.getNome();
            this.comercializadores.put(key,c.clone());
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

    public void addFaturas(LocalDate inicio, LocalDate fim){
        this.casas.forEach((k,v) -> v.addFatura(Fatura.criarFatura(v,inicio,fim)));
    }

    public void ligarAleatorio(){
        this.casas.forEach((k,v) -> v.ligarRandom());
    }

    public SmartHouse maisGastadora() {
        return
        this.casas.values().stream()
                .max(Comparator.comparing(c -> c.getFatura().getConsumo())).get();
    }

    /*
    public Comercializadores maisFaturacao(){

    }
    */


    public List<Fatura> faturasComercializador(String comercializador){
        return
        this.casas.values().stream()
                .filter(c -> c.getFornecedor().getNome().equals(comercializador))
                .map(SmartHouse::getFatura)
                .collect(Collectors.toList());
    }





}
