package SmartDevice;

import java.util.*;
import java.util.stream.Collectors;

public class SmartHouse {
    private String name;
    private int NIF;
    private Map<String,SmartDevice> devices;
    private Map<String,List<String>> divisions;

    public SmartHouse(){
        this.name = "";
        this.NIF = 0;
        this.devices = new HashMap<>();
        this.divisions = new HashMap<>();
    }
    public SmartHouse(SmartHouse sh){
        setName(sh.getName());
        setNIF(sh.getNIF());
        setDevices(sh.getDevices());
        setDivisions(sh.getDivisions());
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNIF() {
        return NIF;
    }

    public void setNIF(int NIF) {
        this.NIF = NIF;
    }

    public Map<String, SmartDevice> getDevices() {
        return this.devices.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, par -> par.getValue().clone()));
    }

    public void setDevices(Map<String, SmartDevice> devices) {
        this.devices = new HashMap<>();
        devices.forEach((key, value) -> this.devices.put(key, value.clone()));
    }

    public Map<String, List<String>> getDivisions() {
        return this.divisions.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, par -> new ArrayList<>(par.getValue())));
    }

    public void setDivisions(Map<String, List<String>> divisions) {
        this.divisions = new HashMap<>();
        divisions.forEach((key, value) -> this.divisions.put(key, new ArrayList<>(value)));
    }

    public boolean equals(Object o){
        if(this == o)
            return true;
        if((o == null) || (this.getClass() != o.getClass()))
            return false;
        SmartHouse sh = (SmartHouse) o;
        return (Objects.equals(name, sh.name) && (NIF == sh.NIF) && Objects.equals(devices, sh.devices) && Objects.equals(divisions,sh.divisions));
    }

    public String toString(){
        return "SmartHouse{\n" +
                "Owner Name: " + name + '\n' +
                "Owner NIF: " + NIF + '\n' +
                "Devices: " + devices + '\n' +
                "Divisions: " + divisions + '\n' +
                "}";
    }

    public SmartHouse clone(){
        return new SmartHouse(this);
    }

    public boolean existsDevice(String device){
        return this.devices.containsKey(device);
    }

    public void addDevice(SmartDevice device){
        this.devices.put(device.getId(),device.clone());
    }

    public SmartDevice getDevice(String device){
        if(existsDevice(device)){
            return this.devices.get(device).clone();
        }
        else{
            return null;
        }
    }

    public void setAllState(boolean state){
        this.devices.values().forEach(k -> k.setState(state));
    }

    public boolean existsDivision (String division){
        return this.divisions.containsKey(division);
    }

    public void addDivision(String division){
        this.divisions.putIfAbsent(division,new ArrayList<>());
    }

    public void addToDivision(String division, String device){
        addDivision(division);
        this.divisions.get(division).add(device);
    }

    public boolean deviceIndivision(String division, String device){
        return (this.divisions.get(division).contains(device));
    }


}
