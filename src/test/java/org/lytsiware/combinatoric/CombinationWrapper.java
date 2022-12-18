package org.lytsiware.combinatoric;

import java.util.Arrays;

public record CombinationWrapper(short[] combination) {

    @Override
    public int hashCode() {
        var copy = Arrays.copyOf(combination, combination.length);
        Arrays.sort(copy);
        return Arrays.hashCode(copy);
    }

    /**
     * This combination is equals to an other when the contain the exact same elements no matter the order
     *
     * @param other the reference object with which to compare.
     * @return
     */
    @Override
    public boolean equals(Object other) {
        if (other instanceof CombinationWrapper s) {
            if (s.combination.length != combination.length) {
                return false;
            }
            var copy1 = Arrays.copyOf(combination, combination.length);
            var copy2 = Arrays.copyOf(s.combination, s.combination.length);
            Arrays.sort(copy1);
            Arrays.sort(copy2);
            return Arrays.equals(copy1, copy2);

        }
        return false;
    }
}
