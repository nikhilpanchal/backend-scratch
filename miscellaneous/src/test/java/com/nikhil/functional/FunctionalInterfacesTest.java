package com.nikhil.functional;

import org.hamcrest.number.IsCloseTo;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;

public class FunctionalInterfacesTest {

    private Functional functional;

    @Before
    public void setup() {
        functional = new Functional();
    }

    @Test
    public void should_create_predicates() {
        boolean emptyStatus = functional.checkStringEmpty("abc");

        assertThat(emptyStatus, is(false));

        emptyStatus = functional.checkStringEmpty("");

        assertThat(emptyStatus, is(true));
    }

    @Test
    public void should_check_string_length_and_emptyness() {
        boolean emptyAndLength = functional.checkStringCombined("thisisastring");

        assertThat(emptyAndLength, equalTo(false));
    }

    @Test
    public void when_temp_provided_in_farenheit_should_convert_to_celcius() {
        double celcius = functional.convertToCelcius(70);

        assertThat("Not converted properly", celcius, closeTo(21.11, 0.009));

        celcius = functional.convertToCelciusUsingUnary(70);
        assertThat("Not converted properly", celcius, closeTo(21.11, 0.009));
    }

    @Test
    public void should_return_the_sum_of_two_numbers() {
        double result = functional.sumNumbers(10, 20);

        assertThat("Not summed properly", result, equalTo(30d));
    }

    @Test
    public void should_return_double_for_string() {
        double result = functional.convertToDouble("20.3");
        assertThat("Not converted properly", result, equalTo(20.3d));
    }

}
