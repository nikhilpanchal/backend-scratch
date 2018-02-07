package com.nikhil.common.tree;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class Tree<T> {
    private final Node<T> root;
}
