package com.akropon.projectEuler.problem6;

import com.akropon.projectEuler.utils.PrimesHelper;
import com.sun.javafx.collections.ImmutableObservableList;

public class Problem6 {

    public static void main(String[] args) {
        long answer = solve(100);
        System.out.println(answer);
    }

    public static long solve(int lastInt) {
        long sumOfSquares = 0;
        long sum = 0;
        for (int i = 1; i <= lastInt ; i++) {
            sumOfSquares += i*i;
            sum += i;
        }
        long squareOfSum = sum * sum;

        return squareOfSum - sumOfSquares;
    }
}
