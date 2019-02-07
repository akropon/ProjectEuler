package com.akropon.projectEuler.problem17;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class Problem17Test {

    @Parameters
    public static Collection<Object[]> data() {
        //noinspection PointlessArithmeticExpression
        return Arrays.asList(new Object[][]{
                {1, 3}, {2, 6}, {3, 11}, {5,19},
                /*from problem*/ {1000, 21124}
        });
    }

    @Parameter
    public int maxInt;

    @Parameter(1)
    public int expectedLettersAmount;

    @Test
    public void solve() {
        assertEquals(expectedLettersAmount, Problem17.solve(maxInt));
    }
}