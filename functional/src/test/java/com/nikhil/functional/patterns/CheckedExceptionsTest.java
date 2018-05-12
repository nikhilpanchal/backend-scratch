package com.nikhil.functional.patterns;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheckedExceptionsTest {
    private static Logger LOGGER = LoggerFactory.getLogger(CheckedExceptionsTest.class);

    @Test
    public void should_throw_checked_exceptions() {
        CheckedExceptions exceptions = new CheckedExceptions();

        try {
            exceptions.doSomething();
        } catch (Exception e) {
            LOGGER.error("Error occured", e);
        }
    }
}
