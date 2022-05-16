package src.view;

public class Output {

    /*
        Apresenta print line
        @param size tamanho
     */
    public void printline(int size){
        for(int i= 0; i < size; i++)
            System.out.println("-");
        System.out.println("");
    }

    /*
        Apresenta Mensagem numa linha terminando com '\n'
        @param message  Mensagem
     */
    public void printMessage(String message){
        System.out.println(message);
    }

    /*
        Clear Screen
     */
    public static void clear(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

}
