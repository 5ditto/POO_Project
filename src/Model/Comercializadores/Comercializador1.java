package src.Model.Comercializadores;

import src.Model.SmartDevice.SmartDevice;

public class Comercializador1 implements Comercializadores{


    public double precoDiaPorDispositivo(SmartDevice dispositivo, int numeroDispositivos){
        return valorBase * dispositivo.consumoDiario() * (1 + impostos) * 0.9;
    }


}