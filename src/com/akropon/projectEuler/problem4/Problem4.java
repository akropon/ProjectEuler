package com.akropon.projectEuler.problem4;

public class Problem4 {

    public static void main(String[] args) {
        int iForMaxPoly = -1;
        int jForMaxPoly = -1;
        int maxPoly = -1;
        for (int i=100; i<=999; i++) {
            for (int j=i; j<=999; j++) {
                int multy = i*j;
                if (isPalindrome(multy)) {
                    if (multy > maxPoly) {
                        maxPoly = multy;
                        iForMaxPoly = i;
                        jForMaxPoly = j;
                    }
                }
            }
        }
        System.out.println(iForMaxPoly+"*"+jForMaxPoly+"="+maxPoly);
    }

    private static int[] buffer = new int[10];
    private static int bufferSize;
    private static boolean isPalindrome(int number) {
        bufferSize = 0;
        while (number != 0) {
            buffer[bufferSize] = number % 10;
            bufferSize++;
            number = number / 10;
        }

        for (int i = 0; i < bufferSize / 2; i++) {
            if (buffer[i] != buffer[bufferSize - 1 - i])
                return false;
        }
        return true;
    }

}
