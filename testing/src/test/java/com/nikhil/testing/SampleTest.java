package com.nikhil.testing;

import org.junit.Test;

import java.util.List;

import static com.nikhil.testing.matchers.MyIntegerMatcher.isAPositiveInteger;
import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsEqual.equalTo;

public class SampleTest {

    @Test
    public void test_hello() {
        assertThat(1, equalTo(1));
    }

    @Test
    public void test_collections() {
        List<Integer> ints = asList(2, 3, 5, 2, 3);

        assertThat(ints, not(empty()));
        assertThat(ints, hasSize(5));
        assertThat(ints, containsInAnyOrder(3, 5, 2, 3, 2));
        assertThat(ints, hasItem(2));
    }

    @Test
    public void test_integers() {
        assertThat(1, greaterThan(-5));
        assertThat(1, isAPositiveInteger());

    }
}
