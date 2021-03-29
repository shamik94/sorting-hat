package main.java;

import main.java.enums.HostelType;
import main.java.exception.CapacityException;
import main.java.service.SortingHatService;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Application {

    public static void main(String args[]) {

        /* Reading the input from text file
        For custom input, create a new file under src/resources */
        File file = new File("./src/main/resources/input-2.txt");

        try {
            Scanner input = new Scanner(file);

            int capacity = Integer.parseInt(
                    input.nextLine().split(" ")[1]
            );

            SortingHatService sortingHatService = new SortingHatService(capacity);

            while (input.hasNextLine()) {
                String line = input.nextLine();
                if (line.equals("fin")) {
                    break;
                }

                // Parsing the input
                String[] inputStringArr = line.split(" ");
                int rollNumber = Integer.parseInt(inputStringArr[1]);
                String hostelTypeString = inputStringArr[2] + inputStringArr[3];

                // Registering Students
                sortingHatService.sortAndRegisterStudent(rollNumber, hostelTypeString);
            }
            input.close();

            printStudentsAndHostels(sortingHatService);

        } catch (FileNotFoundException | CapacityException e) {
            e.printStackTrace();
        }


    }

    private static void printStudentsAndHostels(SortingHatService sortingHatService) {
        for (HostelType type : HostelType.values()) {
            List<Integer> studentsForHostelType = sortingHatService.getStudentsForHostelType(type);
            System.out.print(type.name() + " : [");
            System.out.print(
                    studentsForHostelType.stream().
                    map(Object::toString).
                    collect(Collectors.joining(",")).toString()
            );
            System.out.print("]\n");
        }
    }
}
