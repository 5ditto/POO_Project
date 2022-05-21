package src.Controller;

import java.time.LocalDateTime;
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
        s.nextDouble();
        return b;
    }

}
