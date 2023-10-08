package calculator;

import java.util.ArrayList;
import java.util.List;

public class Summator {
    private int sum = 0;
    private int prevValue = 0;
    private int prevPrevValue = 0;
    private int sumLastThreeValues = 0;
    private int someValue = 0;
    private final int[] listValues = new int[6_600_000];
    private int index = 0;

    public void calc(Data data) {

        int value = data.getValue();
        sum = sum + value;
        sumLastThreeValues = value + prevValue + prevPrevValue;
        prevPrevValue = prevValue;
        prevValue = value;

        int temporal = 0;
        for (int idx = 0; idx < 3; idx++) {
            temporal += (sumLastThreeValues * sumLastThreeValues / (value + 1) - sum);
            temporal = Math.abs(temporal) + index;
        }

        someValue = temporal;
        listValues[index % 6_600_000] = value;
        index++;
    }

    public int getSum() {
        return sum;
    }

    public int getPrevValue() {
        return prevValue;
    }

    public int getPrevPrevValue() {
        return prevPrevValue;
    }

    public int getSumLastThreeValues() {
        return sumLastThreeValues;
    }

    public int getSomeValue() {
        return someValue;
    }
}
