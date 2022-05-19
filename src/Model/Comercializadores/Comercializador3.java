package src.Model.Comercializadores;

import src.Model.SmartDevice.SmartDevice;

public class Comercializador3 implements Comercializadores{

    String nome;

    public Comercializador3(){
        nome = "";
    }

    public Comercializador3(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public static Comercializador3 parse(String line){
        return new Comercializador3(line);
    }

    public double precoDiaPorDispositivo(SmartDevice dispositivo, int numeroDispositivos){

        double preco = numeroDispositivos<10?
                valorBase * dispositivo.consumoDiario() * (1 + impostos) * 1.1 :
                valorBase * dispositivo.consumoDiario() * (1 + impostos) * 0.7;

        return preco;
    }


}