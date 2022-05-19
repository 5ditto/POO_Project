package src.Model.Casas;

import src.Model.Comercializadores.Comercializadores;
import src.Model.Fatura;
import src.Model.SmartDevice.SmartDevice;

import java.util.*;
import java.util.stream.Collectors;

public class SmartHouse {

    private String name;
    private int NIF;
    private double custos_instalacao;
    private Comercializadores fornecedor;

    private Map<UUID, SmartDevice> devices;
    private Map<String,List<UUID>> divisions;
    

    public SmartHouse(){
        this.name = "";
        this.NIF = 0;
        this.custos_instalacao = 0;
        this.fornecedor = null; //fazer com que seja fornecedor 1 em casos default
        this.devices = new HashMap<>();
        this.divisions = new HashMap<>();
    }

    public SmartHouse(String name, int NIF, Comercializadores fornecedor){
        this.name = name;
        this.NIF = NIF;
        this.custos_instalacao = 0;
        this.fornecedor = null;
        this.devices = new HashMap<>();
        this.divisions = new HashMap<>();
    }

    public SmartHouse(SmartHouse sh){
        setName(sh.getName());
        setNIF(sh.getNIF());
        setCustos_instalacao(sh.getCustos_instalacao());
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
        return ( (this.name.equals(sh.getName())) && (this.NIF == sh.getNIF())
                && (this.custos_instalacao == sh.getCustos_instalacao()) && (this.fornecedor.equals(sh.getFornecedor()))
                && (this.devices.equals(sh.getDevices())) && this.divisions.equals(sh.getDivisions()));
    }

    public String toString(){
        return "SmartHouse{\n" +
                "Nome: " + name + '\n' +
                "NIF: " + NIF + '\n' +
                "Custos instalação: " + custos_instalacao + '\n' +
                "Devices: " + devices.values() + '\n' +
                "Divisões: " + divisions.keySet() + '\n' +
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

    private Map<UUID, SmartDevice> getDevices() {
        return this.devices.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, par -> par.getValue().clone()));
    }

    private void setDevices(Map<UUID, SmartDevice> devices) {
        this.devices = new HashMap<>();
        devices.forEach((key, value) -> this.devices.put(key, value.clone()));
    }

    public Map<String, List<UUID>> getDivisions() {
        return this.divisions.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, par -> new ArrayList<>(par.getValue())));
    }

    private void setDivisions(Map<String, List<UUID>> divisions) {
        this.divisions = new HashMap<>();
        divisions.forEach((key, value) -> this.divisions.put(key, new ArrayList<>(value)));
    }

    public double getCustos_instalacao(){
        return custos_instalacao;
    }

    public void setCustos_instalacao(double custos_instalacao){
        this.custos_instalacao = custos_instalacao;
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
        this.custos_instalacao += device.getCusto_instalacao();
    }

    public void rmDevice(SmartDevice device){
        if (this.devices.remove(device.getId()) != null) this.custos_instalacao -= device.getCusto_instalacao();
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


    public double consumoTotalCasaDiario(){
        return  this.devices.values().stream()
                                     .filter(SmartDevice::getState)
                                     .mapToDouble(SmartDevice::consumoDiario)
                                     .sum();
    }

    public double custoTotalCasaDiario(){
        return  this.devices.values().stream()
                .filter(SmartDevice::getState)
                .mapToDouble(val -> fornecedor.precoDiaPorDispositivo(val,devices.size()))
                .sum();
    }


}