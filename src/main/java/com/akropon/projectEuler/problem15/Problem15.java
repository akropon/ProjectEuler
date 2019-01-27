package com.akropon.projectEuler.problem15;

public class Problem15 {

    public static void main(String[] args) {
        long answer = solve(20, 20);
        System.out.println(answer);
    }

    public static long solve(int width, int height) {
        // answer = (width+height)! / width! / height!

        int[] up = new int[width + height];
        int[] down = new int[width + height];

        for (int i = 1; i <= width + height; i++) {
            up[i - 1] = i;
        }
        for (int i = 1; i <= width; i++) {
            down[i - 1] = i;
        }
        for (int i = 1; i <= height; i++) {
            down[width + i - 1] = i;
        }

        /*System.out.println("before simplifying");
        System.out.println(Arrays.toString(up));
        System.out.println(Arrays.toString(down));*/

        // simplifying (it's not the best way, but for solving 20x20 its ok)
        for (int i = 0; i < up.length; i++) {
            for (int j = 0; j < down.length; j++) {
                if (down[j] != 1) {
                    if (up[i] % down[j] == 0) {
                        up[i] = up[i] / down[j];
                        down[j] = 1;
                    }
                }
            }
        }

        /*System.out.println("after simplifying");
        System.out.println(Arrays.toString(up));
        System.out.println(Arrays.toString(down));*/

        long answer = 1;
        for (int i = 0; i < up.length; i++) {
            if (up[i] != 1) {
                answer *= up[i];
            }
        }
        for (int j = 0; j < down.length; j++) {
            if (down[j] != 1) {
                answer /= down[j];
            }
        }

        return answer;

        /*   not working for big numbers
        int a = width >= height ? width : height;
        int b = width >= height ? height : width;

        // a >= b
        long answer = 1;
        for (int i = a+1; i <= a+b; i++) {
            answer *= i;
        }
        for (int i = 2; i <= b; i++) {
            answer /= i;
        }

        return answer;*/
    }


}
