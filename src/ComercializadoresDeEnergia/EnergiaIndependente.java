package src.ComercializadoresDeEnergia;

import src.SmartDevice.SmartDevice;

public class EnergiaIndependente extends ComercializadoresDeEnergia{

    private int desconto;

    public EnergiaIndependente(){
        super();
        desconto = 1;
    }

    public EnergiaIndependente(int desconto){
        super();
        this.desconto = desconto;
    }

    public EnergiaIndependente(EnergiaIndependente comercializador){
        super();
        this.desconto = comercializador.getDesconto();
    }

    public EnergiaIndependente clone(){
        return new EnergiaIndependente(this);
    }

    public int getDesconto() {
        return desconto;
    }

    public void setDesconto(int desconto) {
        this.desconto = desconto;
    }


    public double PrecoDiaPorDispositivo(SmartDevice dispositivo) {
        return getValorBase() * dispositivo.consumoDiario() * (1+getImpostos()) * desconto;
    }



}
