package src.Model.Comercializadores;

import src.Model.SmartDevice.SmartDevice;

public class Comercializador1 implements Comercializadores{

    String nome;

    public Comercializador1(){
        nome = "";
    }

    public Comercializador1(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public static Comercializador1 parse(String line){
        return new Comercializador1(line);
    }

    public double precoDiaPorDispositivo(SmartDevice dispositivo, int numeroDispositivos){
        return valorBase * dispositivo.consumoDiario() * (1 + impostos) * 0.9;
    }


}