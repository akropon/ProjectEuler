package com.akropon.projectEuler.problem10;

import com.akropon.projectEuler.utils.PrimesHelper;
import com.sun.javafx.collections.ImmutableObservableList;

public class Problem10 {

    public static void main(String[] args) {
        long answer = solve(2_000_000 - 1);
        System.out.println(answer);
    }

    public static long solve(int maxPossibleInt) {
        PrimesHelper primesHelper = PrimesHelper.create(maxPossibleInt, false);
        final ImmutableObservableList<Integer> list = primesHelper.getPrimesList();
        long sum = 0;
        for (Integer prime : list) {
            sum += prime;
        }
        return sum;
    }
}
