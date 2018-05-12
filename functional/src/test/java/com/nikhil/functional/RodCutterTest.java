package com.nikhil.functional;

import org.junit.Test;

import static com.nikhil.functional.TestHelper.assertThrows;

public class RodCutterTest {


    @Test(expected = Exception.class)
    public void whenCalledWithZeroLength_shouldThrowException() {
        RodCutter rodCutter = new RodCutter();
        rodCutter.maxProfit(0);
    }

    @Test
    public void whenCalledWithZeroLength_maxProfitShouldThrowException() {
        RodCutter rodCutter = new RodCutter();

        assertThrows(Exception.class, () -> rodCutter.maxProfit(0));
    }
}
