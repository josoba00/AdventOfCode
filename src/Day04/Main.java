package Day04;

import Day03.BatterieBank;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("src/Day04/test.txt"));
        String[][] grid = new String[lines.size()][];
        for (int i = 0; i < lines.size(); i++){
            grid[i] = lines.get(i).split("");
        }
        RollsOfPaper rollsOfPaper = new RollsOfPaper(grid);
        System.out.println(repeatUntilStable(rollsOfPaper));
    }

    private static int repeatUntilStable(RollsOfPaper paperRolls) {
        int previous = 0;
        int current = 0;

        do {
            previous = current;
            current = paperRolls.countAccessPaperRolls();
        } while (previous != current);

        return current;
    }
}