package src.Model.Comercializadores;

import src.Model.SmartDevice.SmartDevice;

public class Comercializador2 implements Comercializadores{


    public double precoDiaPorDispositivo(SmartDevice dispositivo, int numeroDispositivos){

        double preco = numeroDispositivos<5?
                valorBase * dispositivo.consumoDiario() * (1 + impostos) :
                valorBase * dispositivo.consumoDiario() * (1 + impostos) * 0.75;

        return preco;
    }


}