package src.Model.Casas;

import src.Model.Comercializadores.*;
import src.Model.Comercializadores.Comercializador1;
import src.Model.Comercializadores.Comercializador2;
import src.Model.Fatura.Fatura;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


public class GestorComunidade{

    Map<Integer, SmartHouse> casas;
    Map<String, Comercializador> comercializadores;

    public GestorComunidade() {
        casas = new HashMap<>();
        comercializadores = new HashMap<>();
    }

    public GestorComunidade(GestorComunidade gestor) {
        this.setCasas(gestor.getCasas());
        this.setComercializadores(gestor.getComercializadores());
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if ((o == null) || (this.getClass() != o.getClass()))
            return false;
        Object g = (GestorComunidade) o;
        return casas.equals(g);
    }

    public String toString() {
        return "Comunidade [ " + casas.toString() + "]\n";
    }

    public GestorComunidade clone() {
        return new GestorComunidade(this);
    }

    public Map<Integer, SmartHouse> getCasas() {
        Map<Integer, SmartHouse> casas = new HashMap<>();
        for (SmartHouse h : this.casas.values()) {
            int key = h.getNIF();
            casas.put(key, h.clone());
        }
        return casas;
    }

    public void setCasas(Map<Integer, SmartHouse> casas) {
        this.casas = new HashMap<>();
        for (SmartHouse h : casas.values()) {
            int key = h.getNIF();
            this.casas.put(key, h.clone());
        }
    }

    public Map<String, Comercializador> getComercializadores() {
        Map<String, Comercializador> comercializadores = new HashMap<>();
        for (Comercializador c : this.comercializadores.values()) {
            String key = c.getNome();
            comercializadores.put(key, c.clone());
        }
        return comercializadores;
    }

    public void setComercializadores(Map<String, Comercializador> comercializadores) {
        this.comercializadores = new HashMap<>();
        for (Comercializador c : comercializadores.values()) {
            String key = c.getNome();
            this.comercializadores.put(key, c.clone());
        }
    }


    public void addComercializador(Comercializador c){
        comercializadores.put(c.getNome(),c.clone());
    }

    public void addCasa(SmartHouse casa) {
        casas.put(casa.getNIF(), casa.clone());
    }

    public void removeCasa(SmartHouse casa) {
        casas.remove(casa.getNIF());
    }

    public SmartHouse getCasa(int NIF) {
        return casas.get(NIF).clone();
    }

    public void setGestorComunidade(Map<Integer, SmartHouse> casas, Map<String, Comercializador> comercializadores) {
        this.setCasas(casas);
        this.setComercializadores(comercializadores);
    }

    public Map<Integer, Double> consumidoPorCasa() {
        return casas.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, val -> val.getValue().consumoTotalCasaDiario()));
    }

    public Map<Integer, Double> custoPorCasa() {
        return casas.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, val -> val.getValue().custoTotalCasaDiario()));
    }

    public Map<Integer, Double> custoInstalacaoPorCasa() {
        return casas.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, val -> val.getValue().getCustos_instalacao()));
    }

    public void addFaturas(LocalDate inicio, LocalDate fim) {
        this.casas.forEach((k, v) -> v.addFatura(Fatura.criarFatura(v, inicio, fim)));
    }

    public void ligarAleatorio() {
        this.casas.forEach((k, v) -> v.ligarRandom());
    }

    public SmartHouse maisGastadora() {
        return
                this.casas.values().stream()
                        .max(Comparator.comparing(SmartHouse::custoTotalCasaDiario)).get().clone();
    }


    public Comercializador maisFaturacao(){
        List<Fatura> faturas;
        Map<String,Double> consumo = new HashMap<>();
        faturas = this.casas.values().stream().map(SmartHouse::getFaturas).flatMap(ArrayList::stream).collect(Collectors.toCollection(ArrayList::new));
        for (Fatura fatura : faturas){
            consumo.computeIfAbsent(fatura.getComercializador(), v -> fatura.getCustos_consumo() + fatura.getCustos_instalacao());
            consumo.computeIfPresent(fatura.getComercializador(), (k,v) -> v + fatura.getCustos_consumo() + fatura.getCustos_instalacao());
        }

        return
        comercializadores.get(Collections.max(consumo.entrySet(),Map.Entry.comparingByValue()).getKey()).clone();

    }

    public Double volumeFaturacao(Comercializador c){
        return
        this.casas.values()
                .stream()
                .map(SmartHouse::getFaturas)
                .flatMap(ArrayList::stream)
                .filter(f -> f.getComercializador().equals(c.getNome()))
                .mapToDouble(f -> f.getCustos_instalacao() + f.getCustos_consumo())
                .sum();
    }


    public List<Fatura> faturasComercializador(String comercializador) {
        return
                this.casas.values().stream()
                        .map(SmartHouse::getFaturas)
                        .flatMap(ArrayList::stream)
                        .filter(f -> f.getComercializador().equals(comercializador))
                        .collect(Collectors.toList());
    }

    public void mudarFornecedorCasa(int NIF, String comercializador){
        this.casas.get(NIF).setFornecedor(this.comercializadores.get(comercializador).clone());
    }

    public void desligarDevicesDivisaoCasa(int NIF, String divisao) {
        this.casas.get(NIF).turnOffAllDivision(divisao);
    }

    public void ligarDevicesDivisaoCasa(int NIF, String divisao) {
        this.casas.get(NIF).turnOnAllDivision(divisao);
    }

    public void mudarValoresComerciante(String fornecedor, double desconto_maior_new, double desconto_menor_new) {
        Comercializador c = this.comercializadores.get(fornecedor);
        if (c instanceof Comercializador1) {
            ((Comercializador1) c).setDesconto(desconto_maior_new);
        } else {
            if (c instanceof Comercializador2) {
                ((Comercializador2) c).setDescontoMaior(desconto_maior_new);
                ((Comercializador2) c).setDescontoMenor(desconto_menor_new);
            } else if (c instanceof Comercializador3) {
                ((Comercializador3) c).setDescontoMaior(desconto_maior_new);
                ((Comercializador3) c).setDescontoMenor(desconto_menor_new);
            }
        }
    }

    public void ligarDeviceCasa(int NIF, UUID id){
        this.casas.get(NIF).turnOnDevice(id);
    }

    public void desligarDeviceCasa(int NIF, UUID id){
        this.casas.get(NIF).turnOffDevice(id);
    }


    public Set<SmartHouse> getMaxConsumidorTempo(LocalDate inicio, LocalDate fim, int consumidores){
        return
        this.casas.values().stream().sorted(Comparator.comparing( c -> c.volumeFaturaEntreDatas(inicio,fim)).reversed())
                .collect(Collectors.toCollection(TreeSet::new));

    }




    //  



}
