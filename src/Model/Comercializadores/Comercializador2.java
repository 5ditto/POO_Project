package src.Model.Comercializadores;

import src.Model.SmartDevice.SmartDevice;

public class Comercializador2 implements Comercializadores{

    String nome;

    public Comercializador2(){
        nome = "";
    }

    public Comercializador2(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public static Comercializador2 parse(String line){
        return new Comercializador2(line);
    }

    public double precoDiaPorDispositivo(SmartDevice dispositivo, int numeroDispositivos){

        double preco = numeroDispositivos<5?
                valorBase * dispositivo.consumoDiario() * (1 + impostos) :
                valorBase * dispositivo.consumoDiario() * (1 + impostos) * 0.75;

        return preco;
    }


}