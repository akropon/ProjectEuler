package com.akropon.projectEuler.Problem7;

import com.akropon.projectEuler.utils.PrimesHelper;
import com.sun.javafx.collections.ImmutableObservableList;

public class Problem7 {

    public static void main(String[] args) {

        int necessaryElementIndex = 10_001;

        PrimesHelper primesHelper = PrimesHelper.create(1_000_000, false);
        ImmutableObservableList<Integer> list = primesHelper.getPrimesList();
        if (list.size() >= necessaryElementIndex - 1)
            System.out.println("answer="+list.get(necessaryElementIndex-1));
        else
            System.out.println("primes list is too small. It's size = "+list.size());
    }
}
