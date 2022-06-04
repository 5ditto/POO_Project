package src.Model.SmartDevice;

import java.io.Serializable;

public class SmartCamera extends SmartDevice implements Serializable {


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

    public SmartCamera (int resolX, int resolY, double tamanhoFicheiros){
        this.resolX = resolX;
        this.resolY = resolY;
        this.tamanhoFicheiros = tamanhoFicheiros;
    }

    public SmartCamera(SmartCamera sc){
        super(sc.getId(),sc.getState());
        setResolX(sc.getResolX());
        setResolY(sc.getResolY());
        setTamanhoFicheiros(sc.getTamanhoFicheiros());
    }

    public static SmartCamera parse(String line){
        String[] divided = line.split(",");
        String resolutionNoParenthesis = divided[0].replaceAll("[()]", "");
        String[] resolution = resolutionNoParenthesis.split("x");
        int resolX = Integer.parseInt(resolution[0]);
        int resolY = Integer.parseInt(resolution[1]);
        double tamanhoFicheiros = Double.parseDouble(divided[1]);
        return new SmartCamera(resolX,resolY,tamanhoFicheiros);
    }

    public boolean equals(Object o){
        if(o == this)
            return true;
        if((o == null) || (o.getClass() != this.getClass()))
            return false;
        SmartCamera c = (SmartCamera) o;
        return (c.resolX == this.resolX) && (c.resolY == this.resolY)
                && (c.tamanhoFicheiros == this.tamanhoFicheiros) && (super.equals(o));
    }

    public String toString(){
        return "SmartCamera [" + super.toString() +
                " | Resolução: " + resolX + "x" + resolY +
                " | Tamanho dos ficheiros guardados: " + tamanhoFicheiros +
                "]\n";
    }

    public SmartCamera clone(){
        return new SmartCamera(this);
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

    public double getCusto_instalacao(){
        return custo_instalacao;
    }



@Override
    public double consumoDiario(){
        return tamanhoFicheiros*(resolX+resolY)/1500;
    }

}