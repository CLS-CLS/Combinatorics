package org.lytsiware.combinatoric;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Stream;

class CombinationServiceTest {

    @Test
    void generateCombinationTest() {
        var combinationService = new CombinationService();
        var combinations = combinationService.generateCombinations(new short[]{1, 2}, 2).toList();
        Assertions.assertEquals(1, combinations.size());
        Assertions.assertEquals(0, Arrays.compare(new short[]{1, 2}, combinations.get(0)));

        combinations = combinationService.generateCombinations(new short[]{1, 2}, 1).toList();
        Assertions.assertEquals(2, combinations.size());
        Assertions.assertTrue(combinations.stream().allMatch(c -> c.length == 1));
        Assertions.assertTrue(combinations.stream().anyMatch(c -> Arrays.compare(c, new short[]{1}) == 0));
        Assertions.assertTrue(combinations.stream().anyMatch(c -> Arrays.compare(c, new short[]{2}) == 0));

        combinations = combinationService.generateCombinations(new short[]{1, 2, 3, 4, 5}, 2).toList();
        Assertions.assertEquals(10, combinations.size());
        Assertions.assertTrue(combinations.stream().anyMatch(c -> Arrays.compare(c, new short[]{1, 2}) == 0));
        Assertions.assertTrue(combinations.stream().anyMatch(c -> Arrays.compare(c, new short[]{1, 3}) == 0));
        Assertions.assertTrue(combinations.stream().anyMatch(c -> Arrays.compare(c, new short[]{4, 5}) == 0));

        Assertions.assertEquals(10, combinations.stream().map(CombinationWrapper::new).distinct().count());
        Assertions.assertEquals(1, Stream.of(new short[]{1, 2}, new short[]{2,1}).map(CombinationWrapper::new).distinct().count());
    }

}