package org.lytsiware.combinatoric;

import java.util.ArrayList;
import java.util.List;

public class NumberUtils {

    public static List<Integer> primeFactors(long n) {
        var primeFactors = new ArrayList<Integer>();
        int c = 2;
        while (n > 1) {
            if (n % c == 0) {
                primeFactors.add(c);
                n /= c;
            } else
                c++;
        }
        return primeFactors;
    }

}


