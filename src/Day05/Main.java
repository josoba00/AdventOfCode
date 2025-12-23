package Day05;

import Day03.BatterieBank;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("src/Day05/test.txt"));
        String[] values = lines.toArray(String[]::new);
    }
}
