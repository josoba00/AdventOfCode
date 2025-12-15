package Day02;

public class IdRange {
    long MAXIMUM;
    long MINIMUM;

    public IdRange(long MINIMUM, long MAXIMUM) {
        this.MAXIMUM = MAXIMUM;
        this.MINIMUM = MINIMUM;
    }

    public long getMAXIMUM() {
        return MAXIMUM;
    }

    public long getMINIMUM() {
        return MINIMUM;
    }

    public long countInvalidIdsInRange(boolean strict) {
        long sum = 0;
        long min = getMINIMUM();
        long max = getMAXIMUM();
        long cvalue = min;

        while (cvalue <= max) {
            if (strict) {
                if (isStrictlyInvalidId(cvalue)){
                    sum += cvalue;
                }
            } else {
                if (isInvalidId(cvalue)) {
                    sum += cvalue;
                }
            }
            cvalue++;
        }
        return sum;
    }

    private boolean isInvalidId(long num){
        String s = String.valueOf(num);
        int length = s.length();
        if (length % 2 != 0) {
            return false;
        }

        String firstHalf =  s.substring(0, length / 2);
        String secondHalf = s.substring(length / 2);
        return firstHalf.equals(secondHalf);
    }

    private boolean isStrictlyInvalidId(long num){
        String s = String.valueOf(num);
        int length = s.length();
        for (int block = 1; block <= length /2; block++) {
            if (length % block != 0) continue;
            String subBlock = s.substring(0, block);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < length / block; i++) {
                sb.append(subBlock);
                if (sb.toString().equals(s)) return true;
            }
        }
        return false;
    }

}
