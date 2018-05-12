package com.nikhil.functional.patterns;

import com.nikhil.functional.patterns.interfaces.UserInterface;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

public class CheckedExceptions {

    public void doSomething() {
        throw new RuntimeException("Failed");
    }
}
