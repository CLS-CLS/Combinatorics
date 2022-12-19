package org.lytsiware.combinatoric;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.lytsiware.combinatoric.NumberUtils.primeFactors;

public record Fraction(List<Integer> nominators, List<Integer> demominators) {

    public static Fraction of(Integer nominator, Integer denominator) {
        return new Fraction(List.of(nominator), List.of(denominator));
    }

    public Fraction addNominatorTerm(int nominator) {
        var nextNominators = new ArrayList<>(nominators);
        nextNominators.add(nominator);
        return new Fraction(nextNominators, this.demominators);
    }

    public Fraction addDenominatorTerm(int denominator) {
        var nextDenominators = new ArrayList<>(demominators);
        nextDenominators.add(denominator);
        return new Fraction(this.nominators, nextDenominators);
    }

    public Fraction asBreakDownPrimeFactors() {
        var nominatorPrimeFactored = nominators.stream().map(NumberUtils::primeFactors).flatMap(List::stream).sorted().toList();
        var denominatorPrimeFactored = demominators.stream().map(NumberUtils::primeFactors).flatMap(List::stream).sorted().toList();
        return new Fraction(nominatorPrimeFactored, denominatorPrimeFactored);
    }

    public Fraction asSingleTermFraction() {
        return new Fraction(List.of(nominators.stream().reduce(1, (i1, i2) -> i1 * i2)),
                List.of(demominators.stream().reduce(1, (i1, i2) -> i1 * i2)));
    }

    public Fraction toReductedFraction() {
        Fraction singleTerm = asSingleTermFraction();
        return reductToLowestTerms(singleTerm.nominators.get(0), singleTerm.demominators.get(0));
    }

    private static Fraction reductToLowestTerms(long nominator, long denominator) {
        var nominatorPrimes = primeFactors(nominator);
        var denominatorPrimes = primeFactors(denominator);
        Fraction result = new Fraction(Collections.emptyList(), Collections.emptyList());
        int nomIdex = 0;
        int denomIndex = 0;

        while (nomIdex < nominatorPrimes.size() || denomIndex < denominatorPrimes.size()) {
            if (nomIdex == nominatorPrimes.size()) {
                result = result.addDenominatorTerm(denominatorPrimes.get(denomIndex));
                denomIndex++;
            } else if (denomIndex == denominatorPrimes.size()) {
                result = result.addNominatorTerm(nominatorPrimes.get(nomIdex));
                nomIdex++;
            } else {
                var comparison = nominatorPrimes.get(nomIdex).compareTo(denominatorPrimes.get(denomIndex));
                if (comparison < 0) {
                    result = result.addNominatorTerm(nominatorPrimes.get(nomIdex));
                    nomIdex++;
                } else if (comparison == 0) {
                    nomIdex++;
                    denomIndex++;
                } else {
                    result = result.addDenominatorTerm(denominatorPrimes.get(denomIndex));
                    denomIndex++;
                }

            }
        }
        return result;
    }

    @Override
    public String toString() {
        return nominators.stream().map(Object::toString).collect(Collectors.joining(" * ")) + " / " +
                demominators.stream().map(Object::toString).collect(Collectors.joining(" * "));
    }


}
