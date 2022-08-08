package ir.airport.base.ui;
import java.util.Scanner;

public abstract class BaseMenu {

    protected static Scanner string = new Scanner(System.in);
    protected static Scanner number = new Scanner(System.in);

    protected static void scaffolding(){
        System.out.println("=====================");
    }

    public static Scanner getString() {
        return string;
    }

    public static void setString(Scanner string) {
        BaseMenu.string = string;
    }

    public static Scanner getNumber() {
        return number;
    }

    public static void setNumber(Scanner number) {
        BaseMenu.number = number;
    }
}
