package src.Files;

import src.Model.Casas.GestorComunidade;
import src.Model.Casas.SmartHouse;
import src.Model.Comercializadores.Comercializador1;
import src.Model.Comercializadores.Comercializador2;
import src.Model.Comercializadores.Comercializador3;
import src.Model.Comercializadores.Comercializadores;
import src.Model.SmartDevice.SmartBulb;
import src.Model.SmartDevice.SmartCamera;
import src.Model.SmartDevice.SmartDevice;
import src.Model.SmartDevice.SmartSpeaker;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Parser {


    public static List<String> readFile(String fileName){
        List<String> lines = new ArrayList<>();
        try{
            lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        }
        catch (IOException exception){
            System.out.println(exception.getMessage());
        }
        return lines;
    }


    public void parse (GestorComunidade gc) throws LinhaIncorretaException {
        List<String> linhas = readFile("input_files/input.txt");
        Map<String, Comercializadores> comercializadores = new HashMap<>();
        Map<Integer, SmartHouse> casas = new HashMap<>();
        String[] linhaPartida;
        SmartHouse sh = null;
        SmartDevice sd;
        String division = null;
        for (String linha : linhas){
            linhaPartida = linha.split(":",2);
            switch (linhaPartida[0]) {
                case "Fornecedor" -> {
                    Comercializadores c;
                    int randomNum = ThreadLocalRandom.current().nextInt(1, 4);
                    if (randomNum == 1) {
                        c = Comercializador1.parse(linhaPartida[1]);
                    } else if (randomNum == 2) {
                        c = Comercializador2.parse(linhaPartida[1]);
                    } else c = Comercializador3.parse(linhaPartida[1]);
                    comercializadores.put(c.getNome(), c);
                }
                case "Casa" -> {
                    String[] divided = linhaPartida[1].split(",");
                    String name = divided[0];
                    int NIF = Integer.parseInt(divided[1]);
                    Comercializadores cCasa = comercializadores.get(divided[2]);
                    sh = new SmartHouse(name, NIF, cCasa);
                    casas.put(sh.getNIF(), sh);
                    division = null;
                }
                case "Divisão" -> {
                    if (sh == null) throw new LinhaIncorretaException();
                    division = linhaPartida[1];
                    sh.addDivision(division);
                }
                case "SmartBulb" -> {
                    if (division == null) throw new LinhaIncorretaException();
                    sd = SmartBulb.parse(linhaPartida[1]);
                    sh.addDevice(sd, division);
                }
                case "SmartSpeaker" -> {
                    if (division == null) throw new LinhaIncorretaException();
                    sd = SmartSpeaker.parse(linhaPartida[1]);
                    sh.addDevice(sd,division);
                }
                case "SmartCamera" -> {
                    if (division == null) throw new LinhaIncorretaException();
                    sd = SmartCamera.parse(linhaPartida[1]);
                    sh.addDevice(sd,division);
                }
            }
        }

    }




}
