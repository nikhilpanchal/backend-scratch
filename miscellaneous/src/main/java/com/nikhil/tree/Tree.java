package com.nikhil.tree;


import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Value;
import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

@Value
public class Tree<T> {
    private static Logger LOGGER = LoggerFactory.getLogger(Tree.class);

    public static class Node<T> {
        @Getter
        private T value;

        @Getter
        private List<Node<T>> children = Lists.newArrayList();

        public Node(T value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<T> node = (Node<T>) o;
            return Objects.equal(value, node.value) &&
                    Objects.equal(children, node.children);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(value, children);
        }
    }

    public Tree(Node<T> root) {
        this.root = root;
    }

    public Node<T> getRoot() {
        return root;
    }

    private Node<T> root;


    public static void buildSubTree(Node<String> node, Map<String, List<String>> tree) {
        // Get the node's immediate children
        if (!tree.containsKey(node.getValue())) {
            return;
        }

        node.children = tree.get(node.getValue()).stream()
                .map(childValue -> new Node<>(childValue))
                .collect(toList());


        for (Node<String> child : node.children) {
            buildSubTree(child, tree);
        }
    }


    public static Tree buildTree(List<Pair<String, String>> elements) {
        // Build a map of parents and children.
        Map<String, List<String>> tree = elements.stream()
                .filter(p -> p.getLeft() != null)
                .collect(groupingBy(Pair::getLeft, mapping(Pair::getValue, toList())));

        LOGGER.info("The tree built thus far {}", tree);

        // Get the root
        Node<String> root = elements.stream()
                .filter(p -> p.getLeft() == null)
                .map(p -> new Node(p.getRight()))
                .findFirst()
                .get();

        // Build the subtree starting with the root
        buildSubTree(root, tree);

        return new Tree(root);
    }
}

