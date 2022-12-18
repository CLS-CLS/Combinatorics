package org.lytsiware.combinatoric;

import java.util.Arrays;

public class Counter {
    private final int base;
    private final short[] digits;


    public Counter(int base, int numberOfDigits) {
        this.base = base;
        this.digits = initDigits(numberOfDigits);
    }

    public Counter(int base, short[] source) {
        this.base = base;
        this.digits = source;
    }


    public static short[] initDigits(int nominator) {
        var init = new short[nominator];
        for (short i = 0; i < init.length; i++) {
            init[i] = i;
        }
        return init;
    }

    public Counter next() {
        return new Counter(base, next(digits, digits.length - 1));
    }

    private short[] next(short[] current, int index) {
        var copy = Arrays.copyOf(current, current.length);
        if (current[index] >= base) {
            throw new IllegalStateException(String.format("current[%s]=%s is bigger than max %s", index, current[index], base));
        }
        if (current[index] == base - (current.length - index)) {
            copy = next(copy, index - 1);
            copy[index] = (short) (copy[index - 1] + 1);
        } else {
            copy[index] = (short) (copy[index] + 1);
        }
        return copy;
    }

    public boolean hasNext() {
        return digits[0] != base - (digits.length);
    }
    public int getNumberOfDigits() {
        return digits.length;
    }

    public short[] getDigits() {
        return digits;
    }

}