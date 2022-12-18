package org.lytsiware.combinatoric;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.stream.Stream;

public class CombinationService {

    /**
     * generates all the possible combinatins of the source per n
     */
    public Stream<short[]> generateCombinations(short[] source, int nominator) {
        return generateCombinations(source, new Counter(source.length, nominator)).stream();
    }

    private Queue<short[]> generateCombinations(short[] source, Counter counter) {
        short[] combination = mapCounterToSource(source, counter);
        var combinations = new ArrayDeque<short[]>();
        combinations.add(combination);
        if (counter.hasNext()) {
            combinations.addAll(generateCombinations(source, counter.next()));
        }
        return combinations;
    }

    private short[] mapCounterToSource(short[] source, Counter counter) {
        short[] combination = new short[counter.getNumberOfDigits()];
        for (int i = 0; i < counter.getNumberOfDigits(); i++) {
            combination[i] = source[counter.getDigits()[i]];
        }
        return combination;
    }
}
