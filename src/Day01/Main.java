package Day01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Main {

    static PasswordDial passwordDial = new PasswordDial();

    public static void main(String[] args) {
        File file = new File("src/Day01/test.txt");

        try (Scanner myReader = new Scanner(file)) {
            int countZeros = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                int distance = Integer.parseInt(data.substring(1));
                if (data.contains("L")) {
                    countZeros += passwordDial.countZerosLeftRotation(distance);
                    passwordDial.rotateLeft(distance);
                }
                if (data.contains("R")) {
                    countZeros += passwordDial.countZerosRightRotation(distance);
                    passwordDial.rotateRight(distance);
                }
            }
            System.out.println(countZeros);
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}