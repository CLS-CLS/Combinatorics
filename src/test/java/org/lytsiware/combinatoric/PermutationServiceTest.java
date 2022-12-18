package org.lytsiware.combinatoric;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class PermutationServiceTest {


    @Test
    void generatePermutationTest() {
        var permutationService = new PermutationService();

        var permutations = permutationService.generatePermutations(new short[]{1}).collect(Collectors.toList());
        Assertions.assertEquals(1, permutations.size());
        Assertions.assertEquals(1, permutations.get(0)[0]);

        permutations = permutationService.generatePermutations(new short[]{1, 2, 3}).collect(Collectors.toList());
        Assertions.assertEquals(6, permutations.size());
        var expected = List.of(new short[]{1, 2, 3},
                new short[]{1, 3, 2},
                new short[]{2, 1, 3},
                new short[]{2, 3, 1},
                new short[]{3, 1, 2},
                new short[]{3, 2, 1});
        Assertions.assertTrue(permutations.stream().allMatch(p -> expected.stream().anyMatch(r -> Arrays.equals(r, p))));

        permutations = permutationService.generatePermutations(new short[]{1, 2, 3, 4, 5}).collect(Collectors.toList());
        Assertions.assertEquals(120, permutations.size());

    }

}
