package src.Model.SmartDevice;

import java.io.Serializable;

public class SmartSpeaker extends SmartDevice implements Serializable {


    private static final int custo_instalacao = 3;

    private int volume;
    private String estacaoRadio;
    private String marca;
    private double consumoDiario;

    public SmartSpeaker(){
        super();
        this.volume = 0;
        this.estacaoRadio = "";
        this.marca = "";
        this.consumoDiario = 0;
    }

    public SmartSpeaker(SmartSpeaker ss){
        super(ss.getId(),ss.getState());
        setVolume(ss.getVolume());
        setEstacaoRadio(ss.getEstacaoRadio());
        setMarca(ss.getMarca());
        setConsumoDiario(ss.getConsumoDiario());
    }

    public SmartSpeaker(int volume, String estacaoRadio, String marca, double consumoDiario){
        super();
        this.volume = volume;
        this.estacaoRadio = estacaoRadio;
        this.marca = marca;
        this.consumoDiario = consumoDiario;
    }

    public static SmartSpeaker parse(String line){
        String[] divided = line.split(",");
        int volume = Integer.parseInt(divided[0]);
        String estacaoRadio = divided[1];
        String marca = divided[2];
        double consumoDiario = Double.parseDouble(divided[3]);
        return new SmartSpeaker(volume,estacaoRadio,marca,consumoDiario);
    }

    public boolean equals(Object o){
        if(o == this)
            return true;
        if((o == null) || o.getClass() != this.getClass())
            return false;
        SmartSpeaker c = (SmartSpeaker) o;
        return (this.volume == c.volume) && (this.marca.equals(c.getMarca()))
                && (this.estacaoRadio.equals(c.getEstacaoRadio())) && (this.consumoDiario==c.getConsumoDiario())
                && (super.equals(o));
    }

    public String toString(){
        return "SmartSpeaker [" + super.toString() +
                " | Volume: " + volume +
                " | Estação de Rádio Atual: " + estacaoRadio +
                " | Marca: "+ marca + "]\n";

    }

    public SmartSpeaker clone(){
        return new SmartSpeaker(this);
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getEstacaoRadio() {
        return estacaoRadio;
    }

    public void setEstacaoRadio(String estacaoRadio) {
        this.estacaoRadio = estacaoRadio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getConsumoDiario() {
        return consumoDiario;
    }

    public void setConsumoDiario(double consumoDiario) {
        this.consumoDiario = consumoDiario;
    }

    public double getCusto_instalacao(){
        return custo_instalacao;
    }


@Override
    public double consumoDiario(){
        return consumoDiario*volume/100;
    }

}