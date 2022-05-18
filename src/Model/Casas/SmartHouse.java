package src.Model.Casas;

import src.Model.Comercializadores.Comercializadores;
import src.Model.SmartDevice.SmartDevice;

import java.util.*;
import java.util.stream.Collectors;

public class SmartHouse {

    private String name;
    private int NIF;
    private Comercializadores fornecedor;

    private Map<UUID, SmartDevice> devices;
    private Map<String,List<UUID>> divisions;
    

    public SmartHouse(){
        this.name = "";
        this.NIF = 0;
        this.fornecedor = null; //fazer com que seja fornecedor 1 em casos default
        this.devices = new HashMap<>();
        this.divisions = new HashMap<>();
    }

    public SmartHouse(String name, int NIF, Comercializadores fornecedor){
        this.name = name;
        this.NIF = NIF;
        this.fornecedor = null;
        this.devices = new HashMap<>();
        this.divisions = new HashMap<>();
    }

    public SmartHouse(SmartHouse sh){
        setName(sh.getName());
        setNIF(sh.getNIF());
        setFornecedor(sh.getFornecedor());
        setDevices(sh.getDevices());
        setDivisions(sh.getDivisions());
    }

    public boolean equals(Object o){
        if(this == o)
            return true;
        if((o == null) || (this.getClass() != o.getClass()))
            return false;
        SmartHouse sh = (SmartHouse) o;
        return ( (this.name.equals(sh.getName())) && (this.NIF == sh.getNIF()) && (this.fornecedor.equals(sh.getFornecedor()))
                && (this.devices.equals(sh.getDevices())) && this.divisions.equals(sh.getDivisions()));
    }

    public String toString(){
        return "SmartHouse{\n" +
                "Owner Name: " + name + '\n' +
                "Owner NIF: " + NIF + '\n' +
                "Devices: " + devices.values() + '\n' +
                "Divisions: " + divisions.keySet() + '\n' +
                "}";
    }

    public SmartHouse clone(){
        return new SmartHouse(this);
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

    public Comercializadores getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Comercializadores fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Map<UUID, SmartDevice> getDevices() {
        return this.devices.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, par -> par.getValue().clone()));
    }

    public void setDevices(Map<UUID, SmartDevice> devices) {
        this.devices = new HashMap<>();
        devices.forEach((key, value) -> this.devices.put(key, value.clone()));
    }

    public Map<String, List<UUID>> getDivisions() {
        return this.divisions.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, par -> new ArrayList<>(par.getValue())));
    }

    public void setDivisions(Map<String, List<UUID>> divisions) {
        this.divisions = new HashMap<>();
        divisions.forEach((key, value) -> this.divisions.put(key, new ArrayList<>(value)));
    }




    public boolean existsDivision(String division){
        return this.divisions.containsKey(division);
    }

    public void addDivision(String division){
        this.divisions.putIfAbsent(division,new ArrayList<>());
    }

    public SmartDevice getDevice(UUID id_device) {
        return this.devices.get(id_device).clone();
    }

    public void addDevice(SmartDevice device, String division){
        this.devices.put(device.getId(),device.clone());
        addDivision(division);
        this.divisions.get(division).add(device.getId());
    }

    public void rmDevice(SmartDevice device){
        this.devices.remove(device.getId());
        this.divisions.forEach((key,list) -> list.removeIf(id -> id.equals(device.getId())));
    }

    public boolean existsDeviceInDivision(SmartDevice device, String division){
        return (this.divisions.get(division).contains(device.getId()));
    }

    public void turnOnAll(){
        this.devices.forEach((k,v) -> v.setState(true));
    }

    public void turnOffAll(){
        this.devices.forEach((k,v) -> v.setState(false));
    }

    public void turnOnAllDivision(String division){
        this.devices.values().stream().filter(d->existsDeviceInDivision(d,division)).forEach(v -> v.setState(true));
    }

    public void turnOffAllDivision(String division){
        this.devices.values().stream().filter(d->existsDeviceInDivision(d,division)).forEach(v -> v.setState(false));
    }

    public void turnOnDevice(UUID id){
        this.devices.get(id).setState(true);
    }

    public void turnOffDevice(UUID id){
        this.devices.get(id).setState(false);
    }


    //ALTERAR ISTO !!!
    public double consumoTotalCasaDiario(){
        return  this.devices.values().stream()
                                     .filter(SmartDevice::getState)
                                     .mapToDouble(s -> fornecedor.precoDiaPorDispositivo(s,devices.size()))
                                     .sum();
    }



}