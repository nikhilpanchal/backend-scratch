package com.nikhil.streams.collections.pipeline;


@FunctionalInterface
public interface FunctionWithException<T, R, E extends Exception>  {

    R apply(T t) throws E;
}
