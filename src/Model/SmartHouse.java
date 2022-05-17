package src.Model;

import src.Model.Comercializadores.Comercializadores;
import src.Model.SmartDevice.SmartDevice;

import java.util.*;
import java.util.stream.Collectors;

public class SmartHouse {
    private String morada;
    private String name;
    private int NIF;
    private Map<String, SmartDevice> devices;
    private Map<String,List<String>> divisions;
    private Comercializadores energia;

    public SmartHouse(){
        this.morada = "";
        this.name = "";
        this.NIF = 0;
        this.devices = new HashMap<>();
        this.divisions = new HashMap<>();
        this.energia = new Comercializadores();
    }

    public SmartHouse(String morada, String name, int NIF, Map<String,SmartDevice> devices, Map<String,List<String>> divisions, Comercializadores energia){
        this.morada = morada;
        this.name = name;
        this.NIF = NIF;
        this.devices = devices.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, par -> par.getValue().clone()));
        this.divisions = divisions.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, par -> new ArrayList<>(par.getValue())));
        this.energia = energia.clone();
    }

    public SmartHouse(SmartHouse sh){
        setMorada(sh.getMorada());
        setName(sh.getName());
        setNIF(sh.getNIF());
        setDevices(sh.getDevices());
        setDivisions(sh.getDivisions());
        setEnergia(sh.getEnergia());
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
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

    public Comercializadores getEnergia() {
        return energia;
    }

    public void setEnergia(Comercializadores energia) {
        this.energia = energia.clone();
    }

    public boolean equals(Object o){
        if(this == o)
            return true;
        if((o == null) || (this.getClass() != o.getClass()))
            return false;
        SmartHouse sh = (SmartHouse) o;
        return (Objects.equals(morada,sh.morada) && Objects.equals(name, sh.name) && (NIF == sh.NIF) && Objects.equals(devices, sh.devices) && Objects.equals(divisions,sh.divisions));
    }

    public String toString(){
        return "SmartHouse{\n" +
                "Address: " + morada + '\n' +
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

    public void addDevice(SmartDevice device, String division){
        this.devices.put(device.clone());
        addDivision(division);
        this.divisions.get(division).add(device.getId());
    }

    public SmartDevice getDevice(String device) {
        return this.devices.get(device).clone();
    }

    public boolean existsDivision (String division){
        return this.divisions.containsKey(division);
    }

    public void addDivision(String division){
        this.divisions.putIfAbsent(division,new ArrayList<>());
    }

    public void addToDivision(String division, String device){
        if (existsDevice(device)){
            addDivision(division);
            this.divisions.get(division).add(device);
        }
    }

    public boolean deviceInDivision(String division, String device){
        return (this.divisions.get(division).contains(device));
    }

    public void turnOnAll(){
        this.devices.values().forEach(k -> k.setState(true));
    }

    public void turnOffAll(){
        this.devices.values().forEach(k -> k.setState(false));
    }

    public void turnOnAllDivision(String division){
        this.devices.values().stream().filter(d->deviceInDivision(division,d.getId())).forEach(k -> k.setState(true));
    }

    public void turnOffAllDivision(String division){
        this.devices.values().stream().filter(d->deviceInDivision(division,d.getId())).forEach(k -> k.setState(false));
    }

    public void turnOnDevice(String id){
        this.devices.get(id).setState(true);
    }

    public void turnOffDevice(String id){
        this.devices.get(id).setState(false);
    }

    public double consumoTotalCasaDiario(){
        return  this.devices.values().stream()
                                     .filter(SmartDevice::getState)
                                     .mapToDouble(s->energia.precoDiaPorDispositivo(s,devices.size()))
                                     .sum();
    }






}
