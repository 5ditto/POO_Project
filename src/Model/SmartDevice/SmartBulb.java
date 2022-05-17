package src.Model.SmartDevice;

public class SmartBulb extends SmartDevice {

    private static final int COLD = 0;
    private static final int NEUTRAL = 1;
    private static final int WARM = 2;
    private static final int custo_instalacao = 1;

    private int tonalidade;
    private double dimensao;
    private int consumoDiario;


    public SmartBulb(){
        super();
        this.tonalidade = NEUTRAL;
        this.dimensao = 0;
        this.consumoDiario = 0;
    }

    public SmartBulb(int tonalidade, double dimensao, int consumoDiario){
        super();
        this.tonalidade = tonalidade;
        this.dimensao = dimensao;
        this.consumoDiario = consumoDiario;
    }

    public SmartBulb(SmartBulb sb){
        super(sb.getId(),sb.getState());
        setTonalidade(sb.getTonalidade());
        setDimensao(sb.getDimensao());
        setConsumoDiario(sb.getConsumoDiario());
    }

    public boolean equals(Object o){
        if (o == this)
            return true;
        if (!super.equals(o)) return false;
        if (o.getClass()!= this.getClass())
            return false;
        SmartBulb l = (SmartBulb) o;
        return (this.tonalidade==l.getTonalidade()) && (this.dimensao==l.getDimensao())
                && (this.consumoDiario==l.getConsumoDiario());
    }

    public String toString(){
        return "SmartBulb{ \n" +
                "Estado: " + super.getState() + '\n' +
                "Tonalidade"  + tonalidade + '\n' +
                "Dimensão: " + dimensao + '\n' +
                super.toString() +
                "}";
    }

    public SmartBulb clone(){
        return new SmartBulb(this);
    }

    public int getTonalidade() {
        return tonalidade;
    }

    public void setTonalidade(int tonalidade) {
        if (tonalidade>=WARM) this.tonalidade = WARM;
        else if (tonalidade<=COLD) this.tonalidade = COLD;
        else this.tonalidade = NEUTRAL;
    }

    public void setTonalidade(String tonalidade){
        if (tonalidade.equals("WARM")) this.tonalidade = WARM;
        else if (tonalidade.equals("COLD")) this.tonalidade = COLD;
        else this.tonalidade = NEUTRAL;
    }

    public double getDimensao() {
        return dimensao;
    }

    public void setDimensao(double dimensao) {
        this.dimensao = dimensao;
    }

    public int getConsumoDiario() {
        return consumoDiario;
    }

    public void setConsumoDiario(int consumoDiario) {
        this.consumoDiario = consumoDiario;
    }

@Override
    public double consumoDiario(){
        if (this.tonalidade == COLD) return consumoDiario*0.5;
        if (this.tonalidade == NEUTRAL) return consumoDiario;
        else return consumoDiario*1.5;
    }

}