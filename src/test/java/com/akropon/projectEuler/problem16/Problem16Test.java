package com.akropon.projectEuler.problem16;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class Problem16Test {

    @Parameters
    public static Collection<Object[]> data() {
        //noinspection PointlessArithmeticExpression
        return Arrays.asList(new Object[][]{
                {0, 1}, {1, 2}, {2, 4}, {3, 8}, {4, 1 + 6}, {5, 3 + 2}, {6, 6 + 4},
                {7, 1 + 2 + 8}, {8, 2 + 5 + 6}, {9, 5 + 1 + 2}, {10, 1 + 0 + 2 + 4},
                /*from problem*/ {1000, 1366}
        });
    }

    @Parameter
    public int rate;

    @Parameter(1)
    public int expected;

    @Test
    public void solve() {
        assertEquals(expected, Problem16.solve(rate));
    }
}