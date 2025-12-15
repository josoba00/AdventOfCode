package Day03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        File file = new File("src/Day03/test.txt");
        long sum = 0;

        try (Scanner myReader = new Scanner(file)) {
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                int length = line.length();
                int[] digits = new int[length];
                for (int i = 0; i < length; i++) {
                    digits[i] = Character.getNumericValue(line.charAt(i));
                }
                BatterieBank batterieBank = new BatterieBank(digits);
                long value = batterieBank.calculateMaximumJoltage(12);
                System.out.println("Batterie:" + line);
                System.out.println("Maximum:" + value);
                sum += value;
            }
            System.out.println("Sum:" + sum);
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}