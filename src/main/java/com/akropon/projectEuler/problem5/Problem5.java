package com.akropon.projectEuler.problem5;

public class Problem5 {

    public static void main(String[] args) {

        int[] dividers = {11,13,14,16,17,18,19,20};

        MAIN_LOOP:
        for (int number=dividers[dividers.length-1]; number<Integer.MAX_VALUE; number++) {
            for (int divider : dividers) {
                if (number % divider != 0)
                    continue MAIN_LOOP;
            }
            System.out.println(number);
            return;
        }
        System.out.println("fail!");
    }
}
