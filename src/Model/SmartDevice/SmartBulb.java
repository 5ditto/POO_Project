package src.Model.SmartDevice;

public class SmartBulb extends SmartDevice{

    private static final int COLD = 0;
    private static final int NEUTRAL = 1;
    private static final int WARM = 2;
    private static final int custo_instalacao = 1;

    private int tonalidade;
    private double dimensao;
    private double consumoDiario;


    public SmartBulb(){
        super();
        this.tonalidade = NEUTRAL;
        this.dimensao = 0;
        this.consumoDiario = 0;
    }

    public SmartBulb(int tonalidade, double dimensao, double consumoDiario){
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

    public static SmartBulb parse(String line){
        String[] divided = line.split(",");
        String tonalidade_string = divided[0];
        int tonalidade;
        if (tonalidade_string.equals("Cold")) tonalidade = COLD;
        else if (tonalidade_string.equals("Neutral")) tonalidade = NEUTRAL;
        else tonalidade = WARM;
        double dimensao = Double.parseDouble(divided[1]);
        double consumoDiario = Double.parseDouble(divided[2]);
        return new SmartBulb(tonalidade, dimensao, consumoDiario);
    }

    public boolean equals(Object o){
        if (o == this)
            return true;
        if (!super.equals(o)) return false;
        if (o.getClass()!= this.getClass())
            return false;
        SmartBulb l = (SmartBulb) o;
        return (this.tonalidade==l.getTonalidade()) && (this.dimensao==l.getDimensao())
                && (this.consumoDiario==l.getConsumoDiario()) && (super.equals(o));
    }

    public String toString(){
        String tonalidade;
        if (this.tonalidade == COLD) tonalidade = "COlD";
        else if (this.tonalidade == NEUTRAL) tonalidade = "NEUTRAL";
        else tonalidade = "WARM";
        return "SmartBulb: [" + super.toString() +
                " | Tonalidade: "  + tonalidade +
                " | Dimensão: " + dimensao + "]\n";
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
        if (this.tonalidade == COLD) return consumoDiario*0.5;
        if (this.tonalidade == NEUTRAL) return consumoDiario;
        else return consumoDiario*1.5;
    }

}