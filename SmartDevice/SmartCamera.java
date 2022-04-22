package SmartDevice;

import java.util.Objects;

public class SmartCamera extends SmartDevice {
    private int resolX;
    private int resolY;
    private double tamanhaficguardados;

    public SmartCamera(){
        super();
        this.resolX = 0;
        this.resolY = 0;
        this.tamanhaficguardados = 0;
    }

    public SmartCamera(SmartCamera sc){
        setId(sc.getId());
        setState(sc.getState());
        setResolX(sc.getResolX());
        setResolY(sc.getResolY());
        setTamanhaficguardados(sc.getTamanhaficguardados());
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

    public double getTamanhaficguardados() {
        return tamanhaficguardados;
    }

    public void setTamanhaficguardados(double tamanhaficguardados) {
        this.tamanhaficguardados = tamanhaficguardados;
    }

    public boolean equals(Object o){
        if(o == this)
            return true;
        if((o == null) || (o.getClass() != this.getClass()))
            return false;
        SmartCamera c = (SmartCamera) o;
        return ((c.resolX == this.resolX) && (c.resolY == this.resolY) && (c.tamanhaficguardados == this.tamanhaficguardados));
    }

    public String toString(){
        return "SmartCamera{\n" +
                "ID: " + super.getId() + '\n' +
                "State: " + super.getState() + '\n' +
                "Resolução: " + resolX + "x" + resolY + '\n' +
                "Tamanho dos ficheiros guardados : " + tamanhaficguardados +
                "}";
    }

    public SmartCamera clone(){
        return new SmartCamera(this);
    }
}
