package com.nikhil.streams.collections.pipeline;

import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.nikhil.streams.collections.model.Author;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.util.stream.Collectors.toList;

public class Pipeline {
    private Logger logger = LoggerFactory.getLogger(Pipeline.class);

    public List<String> getTwitterHandles(List<Author> authors, String company) {
        // The new way

        // For a stream of authors, get the ones that belong to company, get their twitter handles and remove any whose
        // twitter handles are null
        return authors
                .stream()
                .filter(author -> author.getCompany().equals(company))
                .map(Author::getTwitterHandle)
                .filter(handle -> handle != null)
                .collect(toList());
    }

    private <T, R, E extends Exception> Function<T, R> wrapper(FunctionWithException<T, R, E> fn) {
        Function<T, R> lambda = arg -> {
            try {
                return fn.apply(arg);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };

        return lambda;
    }

    public List<Integer> divideByZero(List<Integer> numbers, Integer factor) {
        return numbers.stream()
                .map(wrapper(num -> num/factor))
                .collect(toList());
    }


    public String encodeString(String... args) {
        return Arrays.stream(args)
                .map(wrapper(s -> URLEncoder.encode(s, "UTF-8")))
                .collect(Collectors.joining(","));
    }
}
