package src.Model.Comercializadores;

import src.Model.SmartDevice.SmartDevice;

public class Comercializador1 extends Comercializadores{

    public Comercializador1(){
        super();
    }

    public double precoDiaPorDispositivo(SmartDevice dispositivo, int numeroDispositivos){
        return getValorBase() * dispositivo.consumoDiario() * (1 + getImpostos()) * 0.9;
    }


}