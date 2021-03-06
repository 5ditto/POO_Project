package src.Model.SmartDevice;


import java.io.Serializable;
import java.util.UUID;

public abstract class SmartDevice implements Serializable {
    private UUID id;
    private boolean state; // true = ligado; false = desligado

    public SmartDevice(){
        this.id = UUID.randomUUID();
        this.state = false;
    }

    public SmartDevice(UUID id, boolean state){
        this.id = id;
        this.state = state;
    }

    public SmartDevice(SmartDevice device){
        setId(device.getId());
        setState(device.getState());
    }

    public UUID getId(){
        return id;
    }

    public void setId(UUID id){
        this.id = id;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public boolean equals(Object o){
        if(this == o)
            return true;
        if((o == null) || (this.getClass() != o.getClass()))
            return false;
        SmartDevice s = (SmartDevice) o;
        return ((this.state == s.getState()) && this.id.equals(s.getId()));
    }

    public String toString(){
        return "Id: " + id + " | State: " + state;
    }

    public abstract SmartDevice clone();

    public abstract double getCusto_instalacao();

    public abstract double consumoDiario();

}

