package src.View;

public class Output {

    public void printMessage(String message){
        System.out.println(message);
    }


    public void printline(String m){
        System.out.print(m);
    }

    public void printOpInvalida(){
        System.out.println("Opção não disponível!");
    }

    public void printNextSimulation(){
        System.out.println("A alteração irá ser executada a próxima vez que correr a simulação!");
    }

    public void printMenus(String []menu, String message, int type){
        int size, length = message.length();

        for(String linha : menu){
            if(linha.length() + 4 > length)
                length = linha.length() + 4;
        }
        if(length < 20)
            length = 20;

        System.out.println(message);

        size = menu.length;
        for(int i = 0; i < size; i++){
            System.out.println(i+1 + " | " + menu[i]);
        }
        if(type == 0) {
            System.out.println("0 | Continuar Simulação");
            System.out.println("9 | Sair");
        } else if (type == 2)
                System.out.println("9 | Sair");
    }
}
