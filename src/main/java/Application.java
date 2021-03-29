package main.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Application {

    public static void main(String args[]) {

        /* Reading the input from text file
        For custom input, create a new file under src/resources */
        File file = new File("./src/main/resources/input-1.txt");

        try {
            Scanner input = new Scanner(file);

            while (input.hasNextLine()) {
                String line = input.nextLine();
                System.out.println(line);
            }
            input.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
