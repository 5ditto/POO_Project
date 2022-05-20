package src.Model.Comercializadores;

import src.Model.SmartDevice.SmartDevice;

public interface Comercializadores {

    double valorBase = 0.07;
    double impostos = 0.06;

    public Comercializadores clone();
    public String getNome();
    public double precoDiaPorDispositivo(SmartDevice dispositivo, int numeroDispositivos);


}
