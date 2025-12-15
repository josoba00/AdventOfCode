package Day03;

import java.util.Arrays;

public class BatterieBank {

    private int[] batteries;
    private int currentIndex;

    public BatterieBank(int[] batteries) {
        this.batteries = batteries;
        this.currentIndex = 0;
    }

    public int calculateMaximumJoltage(){
        int tens = 0;
        int ones = 0;
        for (int i = 0; i < batteries.length-1; i++){
            if (batteries[i] <= tens) {
                continue;
            } else if (batteries[i] > tens) {
                ones = 0;
                tens = batteries[i];
            }
            for (int j = i+1; j < batteries.length; j++){
                if (batteries[j] > ones) {
                    ones = batteries[j];
                }
            }
        }
        return ((tens*10) + ones);
    }

    public long calculateMaximumJoltage(int numBatteries) {
        int length = batteries.length;
        currentIndex = 0;
        int[] newValues = new int[numBatteries];

        for (int pos = 0; pos < numBatteries; pos++) {
            int start = currentIndex;
            int endExclusive = length - (numBatteries - (pos + 1));

            int max = -1;
            int maxIndex = -1;
            for (int i = start; i < endExclusive; i++){
                if (batteries[i] > max) {
                    max = batteries[i];
                    maxIndex = i;
                }
            }
            newValues[pos] = max;
            currentIndex = maxIndex + 1;
        }

        long result = 0;
        for (int num : newValues){
            result = result * 10 + num;
        }
        return result;
    }
}
