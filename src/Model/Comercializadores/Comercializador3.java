package src.Model.Comercializadores;

import src.Model.SmartDevice.SmartDevice;

public class Comercializador3 implements Comercializador {

    private String nome;
    private double descontoMenor = 1.1, descontoMaior = 0.7;

    public Comercializador3(){
        nome = "";
    }

    public Comercializador3(String nome){
        this.nome = nome;
    }

    public Comercializador3(Comercializador3 c){
        this.nome = c.getNome();
        this.descontoMenor = c.getDescontoMenor();
        this.descontoMaior = c.getDescontoMaior();
    }

    @Override
    public String toString() {
        return nome;
    }

    public Comercializador3 clone(){
        return new Comercializador3(this);
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

    public static Comercializador3 parse(String line){
        return new Comercializador3(line);
    }

    public double precoDiaPorDispositivo(SmartDevice dispositivo, int numeroDispositivos){

        double preco = numeroDispositivos<10?
                valorBase * dispositivo.consumoDiario() * (1 + impostos) * descontoMenor:
                valorBase * dispositivo.consumoDiario() * (1 + impostos) * descontoMaior;

        return preco;
    }


}