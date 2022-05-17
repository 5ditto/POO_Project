package src.Model.SmartDevice;

public class SmartCamera extends SmartDevice {


    private static final int custo_instalacao = 5;

    private int resolX;
    private int resolY;
    private double tamanhoFicheiros;

    public SmartCamera(){
        super();
        this.resolX = 0;
        this.resolY = 0;
        this.tamanhoFicheiros = 0;
    }

    public SmartCamera(SmartCamera sc){
        setState(sc.getState());
        setResolX(sc.getResolX());
        setResolY(sc.getResolY());
        setTamanhoFicheiros(sc.getTamanhoFicheiros());
    }

    public int getResolX() {
        return resolX;
    }

    public void setResolX(int resolX) {
        this.resolX = resolX;
    }

    public int getResolY() {
        return resolY;
    }

    public void setResolY(int resolY) {
        this.resolY = resolY;
    }

    public double getTamanhoFicheiros() {
        return tamanhoFicheiros;
    }

    public void setTamanhoFicheiros(double tamanhoFicheiros) {
        this.tamanhoFicheiros = tamanhoFicheiros;
    }

    public boolean equals(Object o){
        if(o == this)
            return true;
        if((o == null) || (o.getClass() != this.getClass()))
            return false;
        SmartCamera c = (SmartCamera) o;
        return (c.resolX == this.resolX) && (c.resolY == this.resolY)
                && (c.tamanhoFicheiros == this.tamanhoFicheiros) && (super.equals(c));
    }

    public String toString(){
        return "SmartCamera{\n" +
                "ID: "  + '\n' +
                "State: " + super.getState() + '\n' +
                "Resolução: " + resolX + "x" + resolY + '\n' +
                "Tamanho dos ficheiros guardados : " + tamanhoFicheiros +
                "}";
    }

    public SmartCamera clone(){
        return new SmartCamera(this);
    }

@Override
    public double consumoDiario(){
        return tamanhoFicheiros*resolX*resolY/1000;
    }




}
