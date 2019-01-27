package com.akropon.projectEuler.problem12;

import com.akropon.projectEuler.utils.PrimesHelper;
import com.sun.javafx.collections.ImmutableObservableList;

public class Problem12 {

    private static final int BUFFERS_INT = 1000;
    private static final int MAX_POSSIBLE_INT_IN_PRIMES_LIST = 1000000;

    public static void main(String[] args) {
        long answer = solve(501);
        System.out.println(answer);
    }

    public static long solve(int minAmountOfDividers) {
        /*int maxAmountOfDividers = 0;
        long memTime = System.currentTimeMillis();*/

        if (minAmountOfDividers <= 1)
            return 1;

        /*  THEORY
        t - integer, p - prime, k - integer, k>0, t>0
        t = p0^k0 * p1^k1 * ... * p(n-1)^k(n-1)
        t % 1 = 0
        t % p0^s0 * p1^s1 * ... * p(n-1)^s(n-1), where s(i) is one of {0,1,2,...,k(i)}
        then t has N dividers, where N = (k0+1)*(k1+1)+...+(k(n-1)+1)
        t - "triangle"
        p - "primeDivider"
        k - "maxPowerOfPrimeDivider"
         */

        int triangle = 0;
        int amountOfPrimeDividers;
        int[] maxPowersOfPrimeDividers = new int[BUFFERS_INT];

        final PrimesHelper primesHelper = PrimesHelper.create(MAX_POSSIBLE_INT_IN_PRIMES_LIST, false);
        final ImmutableObservableList<Integer> primesList = primesHelper.getPrimesList();

        for (int natural = 1; ; natural++) {
            triangle += natural;


            amountOfPrimeDividers = 0;

            int divisible = triangle;
            for (int i = 0; divisible > 1; i++) {
                int prime = primesList.get(i);
                int power = 0;
                while (divisible % prime == 0) {
                    divisible /= prime;
                    power++;
                }
                if (power > 0) {
                    //primeDividers[amountOfPrimeDividers] = prime;
                    maxPowersOfPrimeDividers[amountOfPrimeDividers] = power;
                    amountOfPrimeDividers++;
                }
            }


            int amountOfDividers = 1;
            for (int i = 0; i < amountOfPrimeDividers; i++) {
                amountOfDividers *= maxPowersOfPrimeDividers[i] + 1;
            }

            /*if (amountOfDividers > maxAmountOfDividers) {
                maxAmountOfDividers = amountOfDividers;
                long time = System.currentTimeMillis() - memTime;
                System.out.println("amountOfDividers="+amountOfDividers+" triangle="+triangle+" time="+time);
                memTime += time;
            }*/

            if (amountOfDividers >= minAmountOfDividers)
                return triangle;
        }
    }
}
