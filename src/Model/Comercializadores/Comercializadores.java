package src.Model.Comercializadores;

import src.Model.SmartDevice.SmartDevice;

public class Comercializadores {

    private static final double valorBase = 0.07;
    private static final double impostos = 0.06;

    private int descontoMenor, descontoMaior, numeroDispositivos;
    private boolean descontoNumero;

    public Comercializadores(){
        descontoMenor = 1;
        descontoMaior = 1;
        numeroDispositivos = 0;
        descontoNumero = false;
    }

    public Comercializadores(int descontoMenor, int descontoMaior, int numeroDispositivos, boolean descontoNumero){
        this.descontoMenor = descontoMenor;
        this.descontoMaior = descontoMaior;
        this.numeroDispositivos = numeroDispositivos;
        this.descontoNumero = descontoNumero;
    }

    public Comercializadores(Comercializadores comercializador) {
        this.descontoMenor = comercializador.getDescontoMenor();
        this.descontoMaior = comercializador.getDescontoMaior();
        this.numeroDispositivos = comercializador.getNumeroDispositivos();
        this.descontoNumero = comercializador.getDescontoNumero();
    }

    public double getValorBase(){
        return valorBase;
    }

    public double getImpostos(){
        return impostos;
    }

    public Comercializadores clone(){
        return new Comercializadores(this);
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

    public boolean getDescontoNumero() {
        return descontoNumero;
    }

    public void setDescontoNumero(boolean descontoNumero) {
        this.descontoNumero = descontoNumero;
    }

    public double precoDiaPorDispositivo(SmartDevice dispositivo, int numeroDispositivos) {
        if (this.descontoNumero) {
            if (numeroDispositivos >= this.numeroDispositivos)
                return getValorBase() * dispositivo.consumoDiario() * (1 + getImpostos()) * descontoMaior;
        }
        return getValorBase() * dispositivo.consumoDiario() * (1 + getImpostos()) * descontoMenor;
    }

}
