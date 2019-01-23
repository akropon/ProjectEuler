package com.akropon.projectEuler.utils;

import com.sun.javafx.collections.ImmutableObservableList;

import java.util.ArrayList;
import java.util.List;

public class PrimesHelper /*implements Iterable<Integer> */{

    private List<Integer> primesList = new ArrayList<>();
    private final int maxPossibleInt;


    public static PrimesHelper create(int maxPossibleInteger, boolean withFirstOne) {
        return new PrimesHelper(maxPossibleInteger, withFirstOne);
    }


    public int getMaxPossibleInt() {
        return maxPossibleInt;
    }

    public boolean isPrime(int num) {
        if (num == 1)
            return true;
        int maxIntToTry = (int)Math.sqrt(num);
        for (int prime : primesList) {
            if (prime == 1)
                continue;
            if (prime > maxIntToTry)
                break;
            if (num % prime == 0)
                return false;
        }
        return true;
    }

    public ImmutableObservableList<Integer> getPrimesList() {
        //if (primesList instanceof ImmutableObservableList)
            return (ImmutableObservableList<Integer>) primesList;
    }





    private PrimesHelper(int maxPossibleInteger, boolean withFirstOne) {
        this.maxPossibleInt = maxPossibleInteger;

        if (withFirstOne) {
            if (maxPossibleInteger < 1)
                return;
            primesList.add(1);
        }

        if (maxPossibleInteger < 2)
            return;
        primesList.add(2);

        int num = 3;
        while (num <= maxPossibleInt) {
            if (isPrime(num))
                primesList.add(num);
            num += 2;
        }

        primesList = new ImmutableObservableList<>(primesList.toArray(new Integer[0]));
    }

    /*@Override
    public Iterator<Integer> iterator() {
        return primesList.iterator();
    }*/
}
