package Day01;

public class PasswordDial {
    private Integer start = 50;
    private final int SIZE = 100;
    private int currentValue;

    public PasswordDial(Integer start) {
        this.start = start;
        this.currentValue = start;
    }

    public PasswordDial() {
        this.currentValue = start;
    }

    public int getSIZE() {
        return SIZE;
    }

    public Integer getCurrentValue() {
        return currentValue;
    }

    private void setCurrentValue(int currentValue) {
        this.currentValue = currentValue;
    }

    public void rotateRight(int distance) {
        distance = distance % getSIZE();
        setCurrentValue((getCurrentValue() + distance) % getSIZE());
    }

    public void rotateLeft(int distance) {
        distance = distance % getSIZE();
        int next = getCurrentValue() - distance;
        if (next < 0) {
            next += getSIZE();
        }
        setCurrentValue(next);
    }

    public int countZerosLeftRotation(int distance) {
        int counter = distance / getSIZE();
        if (getCurrentValue() != 0 && getCurrentValue() - (distance % getSIZE()) <= 0) {
            counter++;
        }
        return counter;
    }

    public int countZerosRightRotation(int distance) {
        int counter = distance / getSIZE();
        if (getCurrentValue() + (distance % getSIZE()) > (getSIZE()-1)) {
            counter++;
        }
        return counter;
    }
}