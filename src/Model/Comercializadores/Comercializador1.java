package src.Model.Comercializadores;

import src.Model.SmartDevice.SmartDevice;

public class Comercializador1 implements Comercializadores{

    private String nome;
    private double desconto = 0.9;

    public Comercializador1(){
        nome = "";
    }

    public Comercializador1(String nome){
        this.nome = nome;
    }

    public Comercializador1(Comercializador1 c){
        this.nome = c.getNome();
        this.desconto = c.getDesconto();
    }

    public Comercializador1 clone(){
        return new Comercializador1(this);
    }

    public String getNome() {
        return nome;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto){
        this.desconto = desconto;
    }

    public static Comercializador1 parse(String line){
        return new Comercializador1(line);
    }

    public double precoDiaPorDispositivo(SmartDevice dispositivo, int numeroDispositivos){
        return valorBase * dispositivo.consumoDiario() * (1 + impostos) * desconto;
    }

}