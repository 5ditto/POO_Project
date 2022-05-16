package src.Files;

public class FileInvalidException extends Exception{
    public FileInvalidException(){
        super();
    }

    public FileInvalidException(String s){
        super(s);
    }
}
