package SmartDevice;

import java.util.Objects;

public class SmartSpeaker extends SmartDevice{
    private int volume;
    private String estacaoRadio;
    private String marca;

    public SmartSpeaker(){
        super();
        this.volume = 0;
        this.estacaoRadio = "";
        this.marca = "";
    }

    public SmartSpeaker(SmartSpeaker ss){
        setId(ss.getId());
        setState(ss.getState());
        setVolume(ss.getVolume());
        setEstacaoRadio(ss.getEstacaoRadio());
        setMarca(ss.getMarca());
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

    public boolean equals(Object o){
        if(o == this)
            return true;
        if((o == null) || o.getClass() != this.getClass())
            return false;
        SmartSpeaker c = (SmartSpeaker) o;
        return ((c.volume == this.volume) && Objects.equals(c.marca,this.marca) && Objects.equals(c.estacaoRadio,this.estacaoRadio));
    }

    public String toString(){
        return "SmartSpeaker{\n"+
                "ID: " + super.getId() + '\n' +
                "State: " + super.getState() + '\n' +
                "Volume: " + volume + '\n' +
                "Estação de Rádio Atual: " + estacaoRadio + '\n' +
                "Marca: "+ marca + '\n' +
                "}";

    }

    public SmartSpeaker clone(){
        return new SmartSpeaker(this);
    }
}