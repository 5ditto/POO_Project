package src.Model.Comercializadores;

import src.Model.SmartDevice.SmartDevice;

public abstract class Comercializadores {

    private static final double valorBase = 0.07;
    private static final double impostos = 0.06;

    public double getValorBase(){
        return valorBase;
    }

    public double getImpostos(){
        return impostos;
    }

    public abstract double precoDiaPorDispositivo(SmartDevice dispositivo, int numeroDispositivos);


}
