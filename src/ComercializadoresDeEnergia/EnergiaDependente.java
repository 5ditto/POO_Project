package SmartDevice.ComercializadoresDeEnergia;

import SmartDevice.SmartDevice.SmartDevice;

public class EnergiaDependente extends ComercializadoresDeEnergia{

    private int descontoMenor, descontoMaior, numeroDispositivos;

    public EnergiaDependente(){
        super();
        descontoMenor = 1;
        descontoMaior = 1;
        numeroDispositivos = 10;
    }

    public EnergiaDependente(int descontoMenor, int descontoMaior, int numeroDispositivos){
        super();
        this.descontoMenor = descontoMenor;
        this.descontoMaior = descontoMaior;
        this.numeroDispositivos = numeroDispositivos;
    }

    public EnergiaDependente(EnergiaDependente comercializador){
        super();
        this.descontoMenor = comercializador.getDescontoMenor();
        this.descontoMaior = comercializador.getDescontoMaior();
        this.numeroDispositivos = comercializador.getNumeroDispositivos();
    }

    public int getDescontoMenor() {
        return descontoMenor;
    }

    public void setDescontoMenor(int descontoMenor) {
        this.descontoMenor = descontoMenor;
    }

    public int getDescontoMaior() {
        return descontoMaior;
    }

    public void setDescontoMaior(int descontoMaior) {
        this.descontoMaior = descontoMaior;
    }

    public int getNumeroDispositivos() {
        return numeroDispositivos;
    }

    public void setNumeroDispositivos(int numeroDispositivos) {
        this.numeroDispositivos = numeroDispositivos;
    }

    public double PrecoDiaPorDispositivo(SmartDevice dispositivo, int numeroDispositivos) {
        if (numeroDispositivos < this.numeroDispositivos) return getValorBase() * dispositivo.consumoDiario() * (1+getImpostos()) * descontoMenor;
        else return getValorBase() * dispositivo.consumoDiario() * (1+getImpostos()) * descontoMaior;
    }



}
