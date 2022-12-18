package org.lytsiware.combinatoric;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CounterTest {


    @Test
    void nextText() {
        Counter counter = new Counter(4, 3);
        Assertions.assertArrayEquals(new short[]{0, 1, 2}, counter.getDigits());

        var count2 = counter.next();
        Assertions.assertArrayEquals(new short[]{0, 1, 3}, count2.getDigits());

        var count3 = counter.next().next().next();
        Assertions.assertArrayEquals(new short[]{1, 2, 3}, count3.getDigits());
    }
}
