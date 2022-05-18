package src.Model.Comercializadores;

import src.Model.SmartDevice.SmartDevice;

public class Comercializador2 extends Comercializadores{

    public Comercializador2(){
        super();
    }

    public double precoDiaPorDispositivo(SmartDevice dispositivo, int numeroDispositivos){

        double preco = numeroDispositivos<5?
                getValorBase() * dispositivo.consumoDiario() * (1 + getImpostos()) :
                getValorBase() * dispositivo.consumoDiario() * (1 + getImpostos()) * 0.75;

        return preco;
    }


}