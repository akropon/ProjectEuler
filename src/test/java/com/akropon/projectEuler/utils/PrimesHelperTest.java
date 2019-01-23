package com.akropon.projectEuler.utils;

import com.sun.javafx.collections.ImmutableObservableList;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PrimesHelperTest {

    @Test
    public void getMaxPossibleInt_14() {
        int maxPossibleInt = 14;
        PrimesHelper primesHelper = PrimesHelper.create(maxPossibleInt, false);
        assertEquals(maxPossibleInt, maxPossibleInt);
    }

    @Test
    public void getMaxPossibleInt_0() {
        int maxPossibleInt = 0;
        PrimesHelper primesHelper = PrimesHelper.create(maxPossibleInt, false);
        assertEquals(maxPossibleInt, maxPossibleInt);
    }

    @Test
    public void isPrime_1() {
        int maxPossibleInt = 13;
        PrimesHelper primesHelper = PrimesHelper.create(maxPossibleInt, false);
        assertTrue(primesHelper.isPrime(1));
    }

    @Test
    public void isPrime_1_genWithOne() {
        int maxPossibleInt = 13;
        PrimesHelper primesHelper = PrimesHelper.create(maxPossibleInt, true);
        assertTrue(primesHelper.isPrime(1));
    }

    @Test
    public void isPrime_2() {
        int maxPossibleInt = 13;
        PrimesHelper primesHelper = PrimesHelper.create(maxPossibleInt, false);
        assertTrue(primesHelper.isPrime(2));
    }

    @Test
    public void isPrime_2_genWithOne() {
        int maxPossibleInt = 13;
        PrimesHelper primesHelper = PrimesHelper.create(maxPossibleInt, true);
        assertTrue(primesHelper.isPrime(2));
    }

    @Test
    public void isPrime_3() {
        int maxPossibleInt = 13;
        PrimesHelper primesHelper = PrimesHelper.create(maxPossibleInt, false);
        assertTrue(primesHelper.isPrime(3));
    }

    @Test
    public void isPrime_4() {
        int maxPossibleInt = 13;
        PrimesHelper primesHelper = PrimesHelper.create(maxPossibleInt, false);
        assertFalse(primesHelper.isPrime(4));
    }

    @Test
    public void isPrime_5() {
        int maxPossibleInt = 13;
        PrimesHelper primesHelper = PrimesHelper.create(maxPossibleInt, false);
        assertTrue(primesHelper.isPrime(5));
    }

    @Test
    public void isPrime_12() {
        int maxPossibleInt = 13;
        PrimesHelper primesHelper = PrimesHelper.create(maxPossibleInt, false);
        assertFalse(primesHelper.isPrime(12));
    }

    @Test
    public void isPrime_13() {
        int maxPossibleInt = 13;
        PrimesHelper primesHelper = PrimesHelper.create(maxPossibleInt, false);
        assertTrue(primesHelper.isPrime(13));
    }

    @Test
    public void isPrime_13_genWithOne() {
        int maxPossibleInt = 13;
        PrimesHelper primesHelper = PrimesHelper.create(maxPossibleInt, true);
        assertTrue(primesHelper.isPrime(13));
    }

    @Test
    public void getPrimesList_correctGenerating_withoutOne() {
        int maxPossibleInt = 13;
        PrimesHelper primesHelper = PrimesHelper.create(maxPossibleInt, false);
        List<Integer> list = primesHelper.getPrimesList();
        assertArrayEquals(new Integer[] {2,3,5,7,11,13}, list.toArray(new Integer[0]));
    }

    @Test
    public void getPrimesList_correctGenerating_withOne() {
        int maxPossibleInt = 13;
        PrimesHelper primesHelper = PrimesHelper.create(maxPossibleInt, true);
        List<Integer> list = primesHelper.getPrimesList();
        assertArrayEquals(new Integer[] {1,2,3,5,7,11,13}, list.toArray(new Integer[0]));
    }

    @Test
    public void getPrimesList_immutability() {
        int maxPossibleInt = 13;
        PrimesHelper primesHelper = PrimesHelper.create(maxPossibleInt, false);
        List<Integer> list = primesHelper.getPrimesList();
        try {
            list.set(0, 0);  // trying set element "2" to "0".
        } catch (Exception e) {
            System.out.println("While trying to modify got list from PrimesHelper it was catched the exception "+e.toString());
        }

        // check that it didn't affected on PrimesHelper instance
        list = primesHelper.getPrimesList();
        assertArrayEquals(new Integer[] {2,3,5,7,11,13}, list.toArray(new Integer[0]));
    }
}