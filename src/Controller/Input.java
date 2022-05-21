package src.Controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Input {
    public int readInt (){
        Scanner s = new Scanner(System.in);
        int i = s.nextInt();
        s.nextLine();
        return i;
    }

    public String readline(){
        Scanner s = new Scanner(System.in);
        return s.nextLine();
    }

    public double readDouble(){
        Scanner s = new Scanner(System.in);
        double b = s.nextDouble();
        s.nextLine();
        return b;
    }

    public LocalDate readLocalDate(){
        Scanner s = new Scanner(System.in);
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dia = s.nextLine();
        LocalDate ld = LocalDate.parse(dia, dateFormat);
        return ld;
    }

    public void close() {
        System.exit(0);
    }
}
