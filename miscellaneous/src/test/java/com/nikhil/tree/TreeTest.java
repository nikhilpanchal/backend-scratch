package com.nikhil.tree;

import org.apache.commons.lang3.tuple.Pair;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


import com.nikhil.tree.Tree;

public class TreeTest {

    @Test
    public void givenAListOfParentChildObjects_shouldFormATree() {
        List<Pair<String, String>> treeElements = Lists.newArrayList();

        treeElements.add(Pair.of(null, "Ubaldo"));
        treeElements.add(Pair.of("Ubaldo", "Tony"));
        treeElements.add(Pair.of("Ubaldo", "Rita"));
        treeElements.add(Pair.of("Ubaldo", "Catherine"));
        treeElements.add(Pair.of("Ubaldo", "Mary"));

        treeElements.add(Pair.of("Tony", "Sharon"));
        treeElements.add(Pair.of("Rita", "Anselm"));
        treeElements.add(Pair.of("Mary", "Sandeeta"));
        treeElements.add(Pair.of("Mary", "Nikhil"));

        treeElements.add(Pair.of("Sandeeta", "Shaun"));
        treeElements.add(Pair.of("Sandeeta", "Myra"));

        treeElements.add(Pair.of("Nikhil", "Aiden"));

        treeElements.add(Pair.of("Anselm", "Vanessa"));


        Tree<String> tree = Tree.buildTree(treeElements);

        assertThat(tree.getRoot().getValue(), is("Ubaldo"));
//        assertThat(tree.getRoot().getChildren().size(), is(4));
//        assertThat(tree.getRoot().getChildren().get(3).getChildren().get(1).getChildren().get(0), is("Aiden"));
    }
}
