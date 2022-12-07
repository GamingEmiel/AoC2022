package utils;

import java.io.File;
import java.util.Scanner;

public class Input {

    private Scanner scanner;
    File file;

    public Input(String path) {
        try {
            file = new File(path);
            scanner = new Scanner(file);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public String nextLine() {
        return scanner.nextLine();
    }

    public boolean hasNextLine() {
        return scanner.hasNextLine();
    }

    public void close() {
        scanner.close();
    }
}
