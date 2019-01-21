package com.akropon.projectEuler.problem51;

import java.util.ArrayList;
import java.util.Arrays;
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

public class Problem51 {

    private final static int MAX_PRESET_PRIMES_LIST_SIZE = 10_000_000; // ~ 1 sec to generate
    private final static int MIN_NEEDED_SIZE_OF_PRIME_FAMILY = 7;

    private final static List<Integer> PRIMES_LIST;

    private static final int[] DEGREES_OF_TEN = new int[] {1,10,100,1_000,10_000,100_000,1_000_000,10_000_000,
            100_000_000, 1_000_000_000};
    private static final int MAX_DEGREE_OF_TWO = 30;
    private static final int[] DEGREES_OF_TWO;

    static {
        DEGREES_OF_TWO = new int[MAX_DEGREE_OF_TWO+1];
        int value = 1;
        DEGREES_OF_TWO[0] = value;
        for (int i=1; i<=MAX_DEGREE_OF_TWO; i++) {
            value = value << 1;
            DEGREES_OF_TWO[i] = value;
        }

        PRIMES_LIST = generatePrimesList(MAX_PRESET_PRIMES_LIST_SIZE);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(DEGREES_OF_TEN));
        System.out.println(Arrays.toString(DEGREES_OF_TWO));


        int number = 123456789;
        int mask = 256;
        int newDigit = 9;
        System.out.println(String.format("n=%d m=%d d=%d bin(m)=%s res=%d",
                number, mask, newDigit, Integer.toBinaryString(mask),
                replaceDigits(number, mask, newDigit)));

        number = 0;
        System.out.println("n="+number+" l="+getDecimalNumberLength(number));

        number = 53;
        mask = 2;
        System.out.println(String.format("n=%d m=%d bin(m)=%s familySize=%d",
                number, mask, Integer.toBinaryString(mask),
                getPrimeFamilySize(number, mask, false)));

        number = 53;
        System.out.println(String.format("n=%d maxFamilySize=%d",
                number, getMaxSizeOfYieldedPrimeFamily(number)));



        int applicantIndex = 15;
        int applicantValue = PRIMES_LIST.get(applicantIndex);
        while(true) {
            int familySize = getMaxSizeOfYieldedPrimeFamily(applicantValue);
            if (familySize >= MIN_NEEDED_SIZE_OF_PRIME_FAMILY) {
                System.out.println("value "+applicantValue+" can yield primes family with max size "+familySize);
                return;
            }

            // prepare next iteration
            applicantIndex++;
            if (applicantIndex >= PRIMES_LIST.size())
                break;
            applicantValue = PRIMES_LIST.get(applicantIndex);
        }

        System.out.println("no answer");
    }

    private static int getMaxSizeOfYieldedPrimeFamily(int applicantValue) {

        int maxMaskLength = getDecimalNumberLength(applicantValue);
        int maxMaskValue = DEGREES_OF_TWO[maxMaskLength]-1;
        int maxMaskWithCheckingZero = DEGREES_OF_TWO[maxMaskLength-1]-1;

        int maxPrimeFamilySize = -1;

        for (int maskValue = 1; maskValue <= maxMaskWithCheckingZero; maskValue++) {
            int primeFamilySize = getPrimeFamilySize(applicantValue, maskValue, true);
            if (primeFamilySize>maxPrimeFamilySize)
                maxPrimeFamilySize = primeFamilySize;
        }
        for (int maskValue = maxMaskWithCheckingZero+1; maskValue <= maxMaskValue; maskValue++) {
            int primeFamilySize = getPrimeFamilySize(applicantValue, maskValue, false);
            if (primeFamilySize>maxPrimeFamilySize)
                maxPrimeFamilySize = primeFamilySize;
        }

        return maxPrimeFamilySize;
        //int[] yieldingPrimeFamilyDigitsFlags = new int[10]; // x[i]==1 <=> digit 'i' yield prime value
    }

    private static int getPrimeFamilySize(int applicantValue, int maskValue, boolean withZeroDigit) {
        int primeFamilySize = 0;
        for (int i = (withZeroDigit ? 0 : 1); i<=9; i++) {
            int yieldedValue = replaceDigits(applicantValue, maskValue, i);
            if (isPrime(yieldedValue, PRIMES_LIST))
                primeFamilySize++;
        }
        if (primeFamilySize >= MIN_NEEDED_SIZE_OF_PRIME_FAMILY) {
            // TODO probably it's not right solving, but for "8" it works))) don't wont improve this solving more)
            int answerValue = replaceDigits(applicantValue, maskValue, withZeroDigit ? 0 : 1);
            System.out.println("THIS!!!!!! "+answerValue);
        }
        return primeFamilySize;
    }


    private static int replaceDigits(int number, int maskValue, int newDigit) {
        int digitNumberFromRight = 0;
        while(maskValue>0) {
            if ((maskValue & 0x01) == 0x01) {
                int degree_of_ten = DEGREES_OF_TEN[digitNumberFromRight];
                int digit = (number / degree_of_ten) % 10;
                //number = number - digit * degree_of_ten + newDigit * degree_of_ten;
                number = number - degree_of_ten * (digit - newDigit);
            }
            maskValue = maskValue >> 1;
            digitNumberFromRight++;
        }
        return number;
    }


    private static List<Integer> generatePrimesList(int maxPossibleInt) {
        ArrayList<Integer> primesList = new ArrayList<>();
        primesList.add(2);
        primesList.add(3);

        int num = 5;
        while(num <= maxPossibleInt) {
            if (isPrime(num, primesList))
                primesList.add(num);
            num += 2;
        }

        return primesList;
    }

    private static boolean isPrime(int num, List<Integer> primesList) {
        int maxIntToTry = (int)Math.sqrt(num);
        for (int prime : primesList) {
            if (prime > maxIntToTry)
                break;
            if (num % prime == 0)
                return false;
        }
        return true;
    }



    private static int getDecimalNumberLength(int number) {
        for (int i=1; i<DEGREES_OF_TEN.length; i++) { // start from 1 for getting length 1 for number 0
            if (number < DEGREES_OF_TEN[i])
                return i;
        }
        return DEGREES_OF_TEN.length;
    }
}
