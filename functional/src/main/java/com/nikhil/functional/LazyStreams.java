package com.nikhil.functional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

public class LazyStreams {
    Logger logger = LoggerFactory.getLogger(LazyStreams.class);

    private String firstShortName;

    private int getLength(String name) {
        logger.debug("Length of name {}", name);
        return name.length();
    }

    private String toUpperCase(String name) {
        logger.debug("Coverting name {} to upper case", name);
        return name.toUpperCase();
    }

    public Optional<String> getFirstShortName(List<String> names) {

        return names.stream()
                .filter(name -> getLength(name) == 3)
                .map(this::toUpperCase)
                .findFirst();
    }
}
