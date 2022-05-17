package src.Model.SmartDevice;

public class SmartSpeaker extends SmartDevice{


    private static final int custo_instalacao = 3;

    private int volume;
    private String estacaoRadio;
    private String marca;
    private int consumoDiario;

    public SmartSpeaker(){
        super();
        this.volume = 0;
        this.estacaoRadio = "";
        this.marca = "";
        this.consumoDiario = 0;
    }

    public SmartSpeaker()

    public SmartSpeaker(SmartSpeaker ss){
        setState(ss.getState());
        setVolume(ss.getVolume());
        setEstacaoRadio(ss.getEstacaoRadio());
        setMarca(ss.getMarca());
        setConsumoDiario(ss.getConsumoDiario());
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

    public int getConsumoDiario() {
        return consumoDiario;
    }

    public void setConsumoDiario(int consumoDiario) {
        this.consumoDiario = consumoDiario;
    }

    public boolean equals(Object o){
        if(o == this)
            return true;
        if((o == null) || o.getClass() != this.getClass())
            return false;
        SmartSpeaker c = (SmartSpeaker) o;
        return (this.volume == c.volume) && (this.marca.equals(c.getMarca()))
                && (this.estacaoRadio.equals(c.getEstacaoRadio())) && (this.consumoDiario==c.getConsumoDiario())
                && (super.equals(c));
    }

    public String toString(){
        return "SmartSpeaker{\n"+
                "ID: " + '\n' +
                "State: " + super.getState() + '\n' +
                "Volume: " + volume + '\n' +
                "Estação de Rádio Atual: " + estacaoRadio + '\n' +
                "Marca: "+ marca + '\n' +
                "}";

    }

    public SmartSpeaker clone(){
        return new SmartSpeaker(this);
    }


@Override
    public double consumoDiario(){
        return consumoDiario*volume/100;
    }




}
