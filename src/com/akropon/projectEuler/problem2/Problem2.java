package com.akropon.projectEuler.problem2;

public class Problem2 {

    public static void main(String[] args) {
        long termL = 1;
        long termH = 2;
        long mem;
        long sum = 0;
        while (termH <= 4_000_000) {
        //while (termH <= 35) {
            if (termH % 2L == 0L)
                sum += termH;
            mem = termH;
            termH = termH + termL;
            termL = mem;
        }
        System.out.println("sum = " + sum);
    }
}
