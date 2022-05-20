package src.Model.Comercializadores;

import src.Model.SmartDevice.SmartDevice;

public interface Comercializador {

    double valorBase = 0.07;
    double impostos = 0.06;

    public Comercializador clone();
    public String getNome();
    public double precoDiaPorDispositivo(SmartDevice dispositivo, int numeroDispositivos);


}
