package Day04;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RollsOfPaper {
    String[][] paperRolls;
    private int countRemovableRolls;

    public RollsOfPaper(String[][] paperRolls) {
        this.paperRolls = paperRolls;
    }

    private List<String> getAdjacent(String[][] arr, int i, int j) {
        int n = arr.length;
        int m = arr[0].length;

        List<String> answer = new ArrayList<>();
        int [][] dirs = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};

        // If Outer-Bound return empty list
        if (i < 0 || i >= arr.length || j < 0 || j >= arr[0].length || !arr[i][j].equals("@")) {
            return answer;
        }

        for (int[] dir : dirs){
            int x = i + dir[0];
            int y = j + dir[1];
            // Check Outer-Bounds
            if (x >= 0 && x < arr.length && y >= 0 && y < arr[0].length) {
                answer.add(arr[x][y]);
            }
        }
        return answer;
    }

    public int countAccessPaperRolls() {
        for (int rows = 0; rows < paperRolls.length; rows++){
            for (int cols = 0; cols < paperRolls[0].length; cols++){
                if (Objects.equals(paperRolls[rows][cols], "@")) {
                    List<String> adjacent = getAdjacent(paperRolls, rows, cols);
                    long atNeighbors = adjacent.stream().filter(s -> s.equals("@")).count();
                    if (atNeighbors < 4){
                        paperRolls[rows][cols] = ".";
                        countRemovableRolls++;
                    }
                }
            }
        }
        return countRemovableRolls;
    }
}
