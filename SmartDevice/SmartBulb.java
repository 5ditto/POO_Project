package SmartDevice;

import java.util.Objects;

public class SmartBulb extends SmartDevice {
    private int tonalidade;// O = cold; 1 = neutral; 2 = warm
    private double dimensao;

    public SmartBulb(){
        super();
        this.tonalidade = 0;
        this.dimensao = 0;
    }

    public SmartBulb(String id){
        super(id);
        this.tonalidade = 0;
        this.dimensao = 0;
    }

    public SmartBulb(String id, boolean on){
        super(id, on);
        this.tonalidade = 0;
        this.dimensao = 0;
    }

    public SmartBulb(SmartBulb sb){
        setId(sb.getId());
        setState(sb.getState());
        setTonalidade(sb.getTonalidade());
        setDimensao(sb.getDimensao());
    }


    public int getTonalidade() {
        return tonalidade;
    }

    public void setTonalidade(int tonalidade) {
        this.tonalidade = tonalidade;
    }

    public double getDimensao() {
        return dimensao;
    }

    public void setDimensao(double dimensao) {
        this.dimensao = dimensao;
    }


    public boolean equals(Object o){
        if (o == this)
            return true;
        if ((o == null) || o.getClass()!= this.getClass())
            return false;
        SmartBulb l = (SmartBulb) o;
        return (Objects.equals(l.tonalidade,this.tonalidade) && (l.dimensao == this.dimensao));
    }

    public String toString(){
        return "SmartBulb{ \n" +
                "ID: " + super.getId() + '\n' +
                "State: " + super.getState() + '\n' +
                "Tonalidade"  + tonalidade + '\n' +
                "Dimensão: " + dimensao + '\n' +
                "}";
    }

    public SmartBulb clone(){
        return new SmartBulb(this);
    }
}
