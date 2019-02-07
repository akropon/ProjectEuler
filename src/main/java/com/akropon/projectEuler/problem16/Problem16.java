package com.akropon.projectEuler.problem16;

public class Problem16 {

    public static void main(String[] args) {
        long answer = solve(1000);
        System.out.println(answer);
    }

    public static long solve(int rate) {
        int[] number = new int[] {1};

        for (int i = 1; i <= rate; i++) {
            number = add(number, number);

            StringBuilder str = new StringBuilder();
            str.append("2^").append(i).append("=");
            for (int j = number.length-1; j >= 0 ; j--)
                str.append(number[j]);
            System.out.println(str);
        }

        int sumOfDigitsOfPower = 0;
        for (int i = 0; i < number.length; i++) {
            sumOfDigitsOfPower += number[i];
        }
        return sumOfDigitsOfPower;
    }

    private static int[] add(int[] num1, int[] num2) {
        if (num1.length < num2.length) {
            int[] mem = num1;
            num1 = num2;
            num2 = mem;
        }

        // num1.length >= num2.length

        int extraDigit = 0;
        int[] sum = new int[num1.length];
        int i = 0;
        while (i < num2.length) {
            int digitsSum = num1[i] + num2[i] + extraDigit;
            sum[i] = digitsSum % 10;
            extraDigit = digitsSum >= 10 ? 1 : 0;
            i++;
        }
        while (i < num1.length) {
            int digitsSum = num1[i] + extraDigit;
            sum[i] = digitsSum % 10;
            extraDigit = digitsSum >= 10 ? 1 : 0;
            i++;
        }

        if (extraDigit>0) {
            int[] newSum = new int[sum.length+1];
            for (int j = 0; j < sum.length; j++) {
                newSum[j] = sum[j];
            }
            newSum[newSum.length-1] = extraDigit;
            sum = newSum;
        }

        return sum;
    }
}
