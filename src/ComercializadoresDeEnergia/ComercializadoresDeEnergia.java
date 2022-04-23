package SmartDevice.ComercializadoresDeEnergia;

public abstract class ComercializadoresDeEnergia {

    private static final double valorBase = 0.07;
    private static final double impostos = 0.06;

    public double getValorBase(){
        return valorBase;
    }

    public double getImpostos(){
        return impostos;
    }

}