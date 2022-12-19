package org.lytsiware.combinatoric;

public class Main {

    public static void main(String[] args) {
        var startTime = System.nanoTime();

        var sampleSpace = new VariationService()
                .generateVariations(new short[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}, 9).toList();

        var endTime = System.nanoTime();

        System.out.println("Calculation time " + (endTime - startTime) / 1000000000D);

        var cardAtMost4thTurn = sampleSpace.stream().filter(s -> subArrayContains(s, (short) 1, 7)).count();
        var cardAtMost7thTurn = sampleSpace.stream().filter(s -> subArrayContains(s, (short) 2, 9)).count();
        var both = sampleSpace.stream()
                .filter(s -> subArrayContains(s, (short) 1, 7))
                .filter(s -> subArrayContains(s, (short) 2, 9))
                .count();
        var bothAt4thTurn = sampleSpace.stream()
                .filter(s -> subArrayContains(s, (short) 1, 7))
                .filter(s -> subArrayContains(s, (short) 2, 7)).count();

        System.out.println("P (12,9)  = " + sampleSpace.size());
        System.out.println("(a) card at most 4th turn = " + cardAtMost4thTurn);
        System.out.println("(b) card at most 7th turn = " + cardAtMost7thTurn);
        System.out.println("a and b  = " + both);
        System.out.println(bothAt4thTurn);

        System.out.println("a and b as lowest Fraction: = " + NumberUtils.reductFractionToLowestTerms(both, sampleSpace.size()).asSingleTermFraction()
                + " = " + both / (float) sampleSpace.size());


        var sampleSpace2 = new VariationService().generateVariations(new short[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}, 8).toList();
        var cardAtMost4thTurn2 = sampleSpace2.stream().filter(s -> subArrayContains(s, (short) 1, 7)).count();
        var cardAtMost6thTurn2 = sampleSpace2.stream().filter(s -> subArrayContains(s, (short) 2, 8)).count();
        var both2 = sampleSpace2.stream()
                .filter(s -> subArrayContains(s, (short) 1, 7))
                .filter(s -> subArrayContains(s, (short) 2, 8))
                .count();


        System.out.println("P (11,8)  = " + sampleSpace2.size());
        System.out.println("(a) card at most 4th turn = " + cardAtMost4thTurn2);
        System.out.println("(b) card at most 6th turn = " + cardAtMost6thTurn2);
        System.out.println("a and b  = " + both2);
        System.out.println("a and b as lowest Fraction: = " + NumberUtils.reductFractionToLowestTerms(both2, sampleSpace2.size()).asSingleTermFraction()
                + " = " + both2 / (float) sampleSpace2.size());
    }


    private static boolean subArrayContains(short[] s, short number, int to) {
        return subArrayContains(s, number, 0, to);
    }

    /**
     * @param s      the source array
     * @param number the number to test against
     * @param from   the start index (inclusive) of the subarray
     * @param to     the end index (exlusive) of the subarray
     * @return true if the number is contained in the subarray
     */
    private static boolean subArrayContains(short[] s, short number, int from, int to) {
        for (int i = from; i < to; i++) {
            if (s[i] == number) {
                return true;
            }
        }
        return false;
    }


}
