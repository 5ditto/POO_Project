package src.Model.Fatura;

import src.Model.Casas.SmartHouse;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Fatura {

    private LocalDate inicio, fim;
    private double consumo;
    private double custos_consumo, custos_instalacao;
    private String comercializador;

    public Fatura(){
        inicio = null;
        fim = null;
        consumo = 0;
        custos_consumo = 0;
        custos_instalacao = 0;
        this.comercializador = "";
    }

    public Fatura(LocalDate inicio, LocalDate fim, double consumo, double custos_consumo, double custos_instalacao, String comercializador){
        this.inicio = inicio;
        this.fim = fim;
        this.consumo = consumo;
        this.custos_consumo = custos_consumo;
        this.custos_instalacao = custos_instalacao;
        this.comercializador = comercializador;
    }

    public Fatura(Fatura f){
        setInicio(f.getInicio());
        setFim((f.getFim()));
        setConsumo(f.getConsumo());
        setCustos_consumo(f.getCustos_consumo());
        setCustos_instalacao(f.getCustos_instalacao());
        setComercializador(f.getComercializador());
    }

    public boolean equals(Object o){
        if(this == o)
            return true;
        if((o == null) || (this.getClass() != o.getClass()))
            return false;
        Fatura f = (Fatura) o;
        return ( (this.inicio.equals(f.getInicio())) && (this.fim.equals(f.getFim())) && this.consumo==f.getConsumo()
                 && this.custos_consumo==f.getCustos_consumo() && this.custos_instalacao==f.getCustos_instalacao()
                 && (this.comercializador.equals(f.getComercializador())) );
    }

    @Override
    public String toString() {
        return "Fatura do Comercializador " + comercializador +
                " [Primeiro dia: " + inicio +
                " | Segundo dia: " + fim +
                " | Consumo: " + consumo + "KW" +
                " | Custos do consumo: " + custos_consumo + "€" +
                " | Custos da instalação: " + custos_instalacao + "€" +
                " | Comercializador: " + comercializador + ']';
    }

    public Fatura clone(){
        return new Fatura(this);
    }

    public LocalDate getInicio() {
        return inicio;
    }

    public void setInicio(LocalDate inicio) {
        this.inicio = inicio;
    }

    public LocalDate getFim() {
        return fim;
    }

    public void setFim(LocalDate fim) {
        this.fim = fim;
    }

    public double getConsumo() {
        return consumo;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }

    public double getCustos_consumo() {
        return custos_consumo;
    }

    public void setCustos_consumo(double custos_consumo) {
        this.custos_consumo = custos_consumo;
    }

    public double getCustos_instalacao() {
        return custos_instalacao;
    }

    public void setCustos_instalacao(double custos_instalacao) {
        this.custos_instalacao = custos_instalacao;
    }

    public String getComercializador() {
        return comercializador;
    }

    public void setComercializador(String comercializador) {
        this.comercializador = comercializador;
    }

    public static Fatura criarFatura(SmartHouse casa, LocalDate inicio, LocalDate fim){

        long numero_dias = ChronoUnit.DAYS.between(inicio,fim);
        double consumo = casa.consumoTotalCasaDiario() * numero_dias;
        double custos_consumo = casa.custoTotalCasaDiario() * numero_dias;
        double custos_instalacao = casa.getCustos_instalacao();
        String comercializador = casa.getFornecedor().getNome();

        return new Fatura(inicio,fim,consumo,custos_consumo,custos_instalacao,comercializador);
    }




}
