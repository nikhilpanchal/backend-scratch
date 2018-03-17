package com.nikhil.functional;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class BasicTest {

    @Test
    public void should_start_with_hello_world() {
        Basic b = new Basic();
        assertThat(b.greeting(), equalTo("Hello World!"));
    }
}
