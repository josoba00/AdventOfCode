package Day05;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    record Range(long min, long max){}
    static List<Range> ranges = new ArrayList<>();
    static List<Long> checkIDs = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        try (Scanner sc = new Scanner(new File("src/Day05/test.txt"))){
            boolean readingRanges = true;
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (line.isBlank()) {
                    readingRanges = false;
                    continue;
                }

                if (readingRanges) {
                    String[] parts = line.split("-");
                    long min = Long.parseLong(parts[0]);
                    long max = Long.parseLong(parts[1]);
                    ranges.add(new Range(min,max));
                } else {
                    long id = Long.parseLong(line);
                    checkIDs.add(id);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        long countFresh = 0;

        String[] results = checkStatus();
        for (String value : results) {
            if (Objects.equals(value, "F")) {
                countFresh++;
            }
        }

        System.out.println("Fresh: " + countFresh);
        System.out.println("Num of Fresh Ids: " + countRanges());

    }

    public static long countRanges() {
        ranges.sort((a,b) -> Long.compare(a.min(), b.min()));
        List<Range> mergedRanges = new ArrayList<>();
        for (Range range : ranges){
            if (mergedRanges.isEmpty()){
                mergedRanges.add(range);
            } else {
                Range last = mergedRanges.getLast();
                if (range.min <= last.max) {
                    long newEnd = Math.max(last.max(), range.max());
                    mergedRanges.set(mergedRanges.size() -1, new Range(last.min, newEnd));
                } else {
                    mergedRanges.add(range);
                }
            }
        }

        long totalFresh = 0;
        for (Range range : mergedRanges){
            totalFresh += (range.max() - range.min() + 1);
        }
        return totalFresh;
    }

    public static String[] checkStatus(){
        String[] status = new String[checkIDs.size()];

        for (int i = 0; i < checkIDs.size(); i++){
            boolean state = false;
            for (Range range : ranges) {
                if (checkIDs.get(i) >= range.min && checkIDs.get(i) <= range.max) {
                    state = true;
                }
            }
            if (state) {
                status[i] = "F";
            } else {
                status[i] = "S";
            }
        }
        return status;
    }
}