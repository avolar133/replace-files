import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String searchInDirectory = "/home";
        Communication communication = new Communication(new Scanner(System.in), searchInDirectory);

    }
}