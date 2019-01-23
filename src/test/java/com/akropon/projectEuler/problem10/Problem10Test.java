package com.akropon.projectEuler.problem10;

import org.junit.Test;

import static org.junit.Assert.*;

public class Problem10Test {

    @Test
    public void solve1() {
        assertEquals(142913828922L, Problem10.solve(2_000_000-1));
    }

    @Test
    public void solve2() {
        assertEquals(17, Problem10.solve(10));
    }
}