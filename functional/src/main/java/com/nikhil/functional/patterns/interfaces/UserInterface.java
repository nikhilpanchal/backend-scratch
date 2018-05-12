package com.nikhil.functional.patterns.interfaces;

import java.util.function.Function;

@FunctionalInterface
public interface UserInterface<T, X extends Throwable> {

    void accept(T instance) throws X;
}
