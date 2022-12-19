package org.lytsiware.combinatoric;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class FractionNumberUtilTest {


    @Test
    void primeFactorTest() {
        Assertions.assertEquals(List.of(2, 2, 2, 2), NumberUtils.primeFactors(16));
        Assertions.assertEquals(List.of(2, 3, 5), NumberUtils.primeFactors(30));
    }

    @Test
    void reductFractionTest() {
        Assertions.assertEquals(new Fraction(List.of(2, 3), List.of(5)), Fraction.of(84, 70).toReductedFraction());
    }
}
