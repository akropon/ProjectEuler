package com.akropon.projectEuler.problem8;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Problem8Test {

    @Test
    public void solve_4() {
        assertEquals(5832, Problem8.solve(4));
    }

    @Test
    public void solve_13() {
        assertEquals(23514624000L, Problem8.solve(13));
    }
}