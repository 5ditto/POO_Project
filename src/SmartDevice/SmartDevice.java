package src.SmartDevice;

import java.util.Objects;

public abstract class SmartDevice {
    private String id;
    private boolean state; // true = ligado; false = desligado

    public SmartDevice(){
        this.id = null;
        this.state = false;
    }

    public SmartDevice(String id){
        this.id = id;
        this.state = false;
    }

    public SmartDevice(String id, Boolean state){
        this.id = id;
        this.state = state;
    }

    public SmartDevice(SmartDevice device){
        setId(device.getId());
        setState(device.getState());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
        return ((this.state == s.state) && Objects.equals(this.id,s.id));
    }

    public String toString(){
        return "SmartDevice{ \n"+
                "Id: " + id + '\n' +
                "State: " + state + '\n' +
                "}";
    }

    public abstract SmartDevice clone();

    public abstract double consumoDiario();

}
