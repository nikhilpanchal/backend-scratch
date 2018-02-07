package com.nikhil.common.tree;

import lombok.Builder;
import lombok.Value;

import java.util.Set;

@Value
@Builder
public class Node<T> {
    private final T value;
    private final Set<T> children;
}
