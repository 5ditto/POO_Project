package src.Model.Comercializadores;

import src.Model.SmartDevice.SmartDevice;

public class Comercializador3 implements Comercializadores{


    public double precoDiaPorDispositivo(SmartDevice dispositivo, int numeroDispositivos){

        double preco = numeroDispositivos<10?
                valorBase * dispositivo.consumoDiario() * (1 + impostos) * 1.1 :
                valorBase * dispositivo.consumoDiario() * (1 + impostos) * 0.7;

        return preco;
    }


}