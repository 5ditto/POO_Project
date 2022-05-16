package src.Files;

import src.GestorComunidade;
import src.SmartHouse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    public void parse(GestorComunidade gc) throws FileInvalidException{

    }

    public static List<String> readFile(String fileName){
        List<String> lines;
        try{
           lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        }
        catch (IOException exception){
            lines = new ArrayList<>();
        }
        return lines;
    }
}
