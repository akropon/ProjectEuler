package com.akropon.projectEuler.problem9;

public class Problem9 {

    public static void main(String[] args) {
        long answer = solve();
        System.out.println(answer);
    }

    public static long solve() {
        // a + b + c = 1000 => c = 1000 - a - b
        // a^2 + b^2 = c^2

        LOOP_B:
        for (int b = 1; b<1000; b++) {
            for (int a=1; a<b; a++) {
                int c=1000-a-b;
                if (c < 0)
                    continue LOOP_B;
                if (a* a + b * b == c * c) {
                    return a * b * c;
                }
            }
        }
        return -1;
    }
}
