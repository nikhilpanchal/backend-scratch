package com.nikhil.functional;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LazyStreamsTest {

    @Test
    public void whenCalledWithACollectionOfNames_shouldPrintInCapsTheFirstNameThatIsThreeCharsLong() {
        LazyStreams lazyStreams = new LazyStreams();

        // given
        List<String> names = Lists.newArrayList("Nikhil", "Erica", "Aiden", "Ola", "Abu", "Diaby");

        Optional<String> shortName = lazyStreams.getFirstShortName(names);

        assertThat(shortName.isPresent(), is(Boolean.TRUE));
        assertThat(shortName.get(), is("OLA"));

    }
}
