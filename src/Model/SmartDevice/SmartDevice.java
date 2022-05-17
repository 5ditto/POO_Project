package src.Model.SmartDevice;

import java.util.Objects;
import java.lang.Object

public abstract class SmartDevice {
    private String id;
    private boolean state; // true = ligado; false = desligado

    public SmartDevice(){
        this.id
        this.state = false;
    }

    public SmartDevice(String id, boolean state){
        this.id = id;
        this.state = state;
    }

    public SmartDevice(SmartDevice device){
        setId(device.getId());
        setState(device.getState());
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
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
        return "Id: " + state + '\n' +
               "State: " + state + '\n';
    }

    public abstract SmartDevice clone();

    public abstract double consumoDiario();

}

