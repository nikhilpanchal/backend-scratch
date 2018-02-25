package com.nikhil.streams.collections.model;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class Author {
    private final String name;
    private final String twitterHandle;
    private final String company;
}
