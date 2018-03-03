package com.nikhil.testing.matchers;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Test;

public class MyIntegerMatcher extends TypeSafeMatcher<Integer> {


    @Override
    protected boolean matchesSafely(Integer integer) {
        return integer > 0;
    }

    @Factory
    public static Matcher<Integer> isAPositiveInteger() {
        return new MyIntegerMatcher();
    }


    @Override
    public void describeTo(Description description) {
        description.appendText("Checks for Type safety");
    }
}
