package src.Controller;

import src.Files.SaveLoadState;
import src.Model.Comercializadores.Comercializador;
import src.Model.Comercializadores.Comercializador1;
import src.Model.Fatura.Fatura;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;

public interface InterfaceInterpretador {
    public void interpretadorMenuPrincipal();

    public void interpretadorConsultas();

    public void interpretadorAlteracoes(List<Consumer<String>> methodList) ;

    public void interpretadorDados();
}
