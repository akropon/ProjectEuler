package com.akropon.projectEuler.problem14;

public class Problem14 {

    public static void main(String[] args) {
        long answer = solve();
        System.out.println(answer);
    }

    public static long solve() {
        long maxChainLength = 0;
        long numThatGensMaxChain = 0;

        for (long i = 1; i < 1_000_000; i++) {
        //for (long i = 1; i < 14; i++) {
            long num = i;
            long chainLength = 1;
            while (num > 1) {
                num = getNext(num);
                chainLength++;
            }
            if (chainLength > maxChainLength) {
                maxChainLength = chainLength;
                numThatGensMaxChain = i;
                //System.out.println("gen="+numThatGensMaxChain+" chainLength="+maxChainLength);
            }
        }

        return numThatGensMaxChain;
    }

    private static long getNext(long num) {
        if (num % 2 == 0)
            return num / 2;
        else
            return 3*num + 1;
    }


}
