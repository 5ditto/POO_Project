package src.Model.Comercializadores;

import src.Model.SmartDevice.SmartDevice;

public class Comercializador3 extends Comercializadores{

    public Comercializador3(){
        super();
    }

    public double precoDiaPorDispositivo(SmartDevice dispositivo, int numeroDispositivos){

        double preco = numeroDispositivos<10?
                getValorBase() * dispositivo.consumoDiario() * (1 + getImpostos()) * 1.1 :
                getValorBase() * dispositivo.consumoDiario() * (1 + getImpostos()) * 0.65;

        return preco;
    }


}