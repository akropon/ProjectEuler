package com.akropon.projectEuler.problem12;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Problem12Test {

    @Test
    public void solve_1() {
        assertEquals(1, Problem12.solve(1));
    }

    @Test
    public void solve_2() {
        assertEquals(3, Problem12.solve(2));
    }

    @Test
    public void solve_3() {
        assertEquals(6, Problem12.solve(3));
    }

    @Test
    public void solve_4() {
        assertEquals(6, Problem12.solve(4));
    }

    @Test
    public void solve_5() {
        assertEquals(28, Problem12.solve(5));
    }

    @Test
    public void solve_6() {
        assertEquals(28, Problem12.solve(6));
    }

    @Test
    public void solve_501() {
        assertEquals(76576500, Problem12.solve(501));
    }
}