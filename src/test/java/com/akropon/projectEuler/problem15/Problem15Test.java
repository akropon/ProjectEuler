package com.akropon.projectEuler.problem15;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Problem15Test {

    @Test
    public void solve_2x2() {
        assertEquals(6, Problem15.solve(2,2));
    }

    @Test
    public void solve_1x1() {
        assertEquals(2, Problem15.solve(1,1));
    }

    @Test
    public void solve_1x2() {
        assertEquals(3, Problem15.solve(1,2));
    }

    @Test
    public void solve_2x1() {
        assertEquals(3, Problem15.solve(2,1));
    }

    @Test
    public void solve_1x3() {
        assertEquals(4, Problem15.solve(1,3));
    }

    @Test
    public void solve_3x1() {
        assertEquals(4, Problem15.solve(3,1));
    }

    @Test
    public void solve_20x20() {
        assertEquals(137846528820L, Problem15.solve(20,20));
    }


}