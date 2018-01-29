package com.nikhil.functional;

@FunctionalInterface
public interface CustomFunctional<T, R> {
    R doIt(T t);
}
