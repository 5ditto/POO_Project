package src.Model.Comercializadores;

import src.Model.SmartDevice.SmartDevice;

import java.io.Serializable;

public class Comercializador2 implements Comercializador,Serializable {

    private String nome;
    private double descontoMenor = 1, descontoMaior = 0.75;

    public Comercializador2(){
        nome = "";
    }

    public Comercializador2(String nome){
        this.nome = nome;
    }

    public Comercializador2(Comercializador2 c){
        this.nome = c.getNome();
        this.descontoMenor = c.getDescontoMenor();
        this.descontoMaior = c.getDescontoMaior();
    }

    @Override
    public String toString() {
        return nome;
    }

    public Comercializador2 clone(){
        return new Comercializador2(this);
    }

    public String getNome() {
        return nome;
    }

    public double getDescontoMenor() {
        return descontoMenor;
    }

    public void setDescontoMenor(double descontoMenor) {
        this.descontoMenor = descontoMenor;
    }

    public double getDescontoMaior() {
        return descontoMaior;
    }

    public void setDescontoMaior(double descontoMaior) {
        this.descontoMaior = descontoMaior;
    }

    public static Comercializador2 parse(String line){
        return new Comercializador2(line);
    }

    public double precoDiaPorDispositivo(SmartDevice dispositivo, int numeroDispositivos){

        double preco = numeroDispositivos<5?
                valorBase * dispositivo.consumoDiario() * (1 + impostos) * descontoMenor :
                valorBase * dispositivo.consumoDiario() * (1 + impostos) * descontoMaior;

        return preco;
    }


}