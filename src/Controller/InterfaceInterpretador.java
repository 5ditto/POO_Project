package src.Controller;

import src.Model.Comercializadores.Comercializador;
import src.Model.Comercializadores.Comercializador1;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;

public interface InterfaceInterpretador {
    public void interpretador() throws ClassNotFoundException, IOException;

    public void interpretadorConsultas();

    public void interpretadorAlteracoes(List<Consumer<String>> methodList);
}
