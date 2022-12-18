package org.lytsiware.combinatoric;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

class VariationServiceTest {


    @Test
    void generateVariationTest() {
        var variationService = new VariationService();
        var variations = variationService.generateVariations(new short[]{1, 2, 3, 4, 5}, 2).collect(Collectors.toList());
        Assertions.assertEquals(20, variations.size());

        variations = variationService.generateVariations(new short[]{1, 2, 3, 4, 5}, 1).collect(Collectors.toList());
        Assertions.assertEquals(5, variations.size());

        variations = variationService.generateVariations(new short[]{1, 2, 3, 4, 5}, 5).collect(Collectors.toList());
        Assertions.assertEquals(120, variations.size());

        variations = variationService.generateVariations(new short[]{1, 2, 3, 4, 5, 6, 7,}, 3).collect(Collectors.toList());
        Assertions.assertEquals(210, variations.size());
    }

}