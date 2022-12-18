package org.lytsiware.combinatoric;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PermutationService {

    /**
     * generates all the possible permutation of the source
     */
    public Stream<short[]> generatePermutations(short[] source) {
        return generatePermutations(source, 0, new short[source.length]);
    }

    private Stream<short[]> generatePermutations(short[] source, int index, short[] mutation) {
        if (index == source.length) {
            return Stream.of(mutation);
        }

        return IntStream.range(0, mutation.length)
                .parallel()
                .filter(i -> mutation[i] == 0)
                .mapToObj(i -> mutateWithNumberAtIndex(source[index], i, mutation))
                .flatMap(m -> generatePermutations(source, index + 1, m));

    }

    private short[] mutateWithNumberAtIndex(short number, int index, short[] source) {
        short[] copy = Arrays.copyOf(source, source.length);
        copy[index] = number;
        return copy;
    }

}
