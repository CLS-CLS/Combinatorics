package org.lytsiware.combinatoric;

import java.util.stream.Stream;

public class VariationService {

    final CombinationService combinationService = new CombinationService();
    final PermutationService permutationService = new PermutationService();

    /**
     * Generates all possible variations of the source per n
     */
    public Stream<short[]> generateVariations(short[] source, int n) {
        return combinationService.generateCombinations(source, n)
                .parallel()
                .flatMap(permutationService::generatePermutations);
    }
}
