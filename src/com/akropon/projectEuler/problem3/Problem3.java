package com.akropon.projectEuler.problem3;

import java.util.ArrayList;
import java.util.List;


/**
 * By replacing the 1st digit of the 2-digit number *3, it turns out that six of the nine possible values:
 * 13, 23, 43, 53, 73, and 83, are all prime.
 *
 * By replacing the 3rd and 4th digits of 56**3 with the same digit,
 * this 5-digit number is the first example having seven primes among the ten generated numbers,
 * yielding the family: 56003, 56113, 56333, 56443, 56663, 56773, and 56993. Consequently 56003,
 * being the first member of this family, is the smallest prime with this property.
 *
 * Find the smallest prime which, by replacing part of the number (not necessarily adjacent digits)
 * with the same digit, is part of an eight prime value family.
 *
 */

public class Problem3 {

    private final static long MAX_PRESET_PRIMES_LIST_SIZE = 10_000_000; // ~ 1 sec to generate

    private final static List<Long> PRIMES_LIST;


    static {
        PRIMES_LIST = generatePrimesList(MAX_PRESET_PRIMES_LIST_SIZE);
    }

    public static void main(String[] args) {
        List<Long> factors = new ArrayList<>();

        long number = 600851475143L;
        long value = number;
        long maxPossibleDivider = (long)Math.sqrt(value);
        int divider_index = 0;
        long divider = PRIMES_LIST.get(divider_index);
        while(true) {
            if (value % divider == 0) {
                value = value / divider;
                factors.add(divider);
                if (value == 1)
                    break;
            } else {
                divider_index++;
                divider = PRIMES_LIST.get(divider_index);
                if (divider > maxPossibleDivider) {
                    factors.add(value);
                    break;
                }
            }
        }

        System.out.println(value + " = " + factors);

        // checking
        long multi = 1;
        for (Long factor : factors) {
            multi *= factor;
        }
        System.out.println("multiplying of factors = "+multi+". Is it right: "+(multi==number));

    }




    private static List<Long> generatePrimesList(long maxPossibleInt) {
        ArrayList<Long> primesList = new ArrayList<>();
        primesList.add(2L);
        primesList.add(3L);

        long num = 5;
        while(num <= maxPossibleInt) {
            if (isPrime(num, primesList))
                primesList.add(num);
            num += 2L;
        }

        return primesList;
    }

    private static boolean isPrime(long num, List<Long> primesList) {
        long maxIntToTry = (long)Math.sqrt(num);
        for (long prime : primesList) {
            if (prime > maxIntToTry)
                break;
            if (num % prime == 0)
                return false;
        }
        return true;
    }

}
