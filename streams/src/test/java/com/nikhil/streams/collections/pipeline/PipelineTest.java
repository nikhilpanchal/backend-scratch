package com.nikhil.streams.collections.pipeline;

import com.nikhil.streams.collections.model.Author;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class PipelineTest {
    Pipeline pipeline;
    private static Logger logger = LoggerFactory.getLogger(PipelineTest.class);

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setup() {
        pipeline = new Pipeline();
    }

    @Test
    public void should_get_the_twitter_handles_of_authors_of_a_company() {
        // given
        Author author1 = Author.builder()
                .name("Nikhil")
                .company("Financier")
                .twitterHandle("@nikhilp78")
                .build();

        Author author2 = Author.builder()
                .name("Erica")
                .company("Financier")
                .twitterHandle("@ericap")
                .build();

        Author author3 = Author.builder()
                .name("Aiden")
                .company("PSJC")
                .twitterHandle("aidenp")
                .build();

        List<Author> authors = asList(author1, author2, author3);

        // when
        List<String> twitterHandlers = pipeline.getTwitterHandles(authors, "Financier");

        // then
        assertThat(twitterHandlers.size(), equalTo(2));
        assertThat(twitterHandlers, containsInAnyOrder("@nikhilp78", "@ericap"));
    }


    @Test
    public void should_scale_numbers_by_number() {
        List<Integer> result = pipeline.divideByZero(asList(2, 3, 4, 6, 4, 5, 8, 23, 3), 3);

        assertThat(result, containsInAnyOrder(0, 1, 1, 2, 1, 1, 2, 7, 1));

        expectedException.expect(RuntimeException.class);
        expectedException.expectCause(isA(ArithmeticException.class));
        pipeline.divideByZero(asList(2, 3, 4, 6, 4, 5, 8, 23, 3), 0);
    }

    @Test
    public void should_url_encode_strings() {
        String results = pipeline.encodeString("Encode me", "http://my.site?and=some&query=params");

        assertThat(results, is("Encode+me,http%3A%2F%2Fmy.site%3Fand%3Dsome%26query%3Dparams"));
    }
}
