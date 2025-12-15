package Day02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        File file = new File("src/Day02/test.txt");

        try (Scanner myReader = new Scanner(file)) {
            String line = myReader.nextLine();
            String[] ranges = line.split(",");
            long sum = 0;
            for (String value : ranges) {
                String[] minmax = value.split("-");
                IdRange idRange = new IdRange(Long.parseLong(minmax[0]), Long.parseLong(minmax[1]));
                sum += idRange.countInvalidIdsInRange(true);
            }
            System.out.println("Sum Invalid Ids: " + sum);

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
