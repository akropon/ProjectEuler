package com.akropon.projectEuler.problem112;

public class Problem112 {

    public static void main(String[] args) {
        double targetProportion = 0.99;
        int bouncyAmount = 0;
        int i = 0;

        /*int n = 122;
        System.out.println(n + " is bouncy = "+isBouncy(n));*/


        while(true) {
            i++;

            if (isBouncy(i))
                bouncyAmount++;

            double proportion = (double)bouncyAmount / i;
            if (proportion >= targetProportion) {
                System.out.println(i);
                break;
            }
        }
    }

    private static boolean isBouncy(int num) {
        boolean isIncreasing = true;
        boolean isDecreasing = true;

        int rightDigit;
        int currentDigit = num % 10;
        num = num / 10;
        while(num!=0) {
            rightDigit = currentDigit;
            currentDigit = num % 10;
            num = num / 10;

            if (isDecreasing && currentDigit < rightDigit)
                isDecreasing = false;
            if (isIncreasing && currentDigit > rightDigit)
                isIncreasing = false;
            if (!isIncreasing && !isDecreasing)
                return true;
        }

        return !isIncreasing && !isDecreasing;
    }
}
