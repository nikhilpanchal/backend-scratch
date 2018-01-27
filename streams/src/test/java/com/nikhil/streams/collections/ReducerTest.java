package com.nikhil.streams.collections;

import com.nikhil.streams.collections.model.PerformanceData;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.core.IsEqual;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ReducerTest {

    private Reducer reducer;

    @Before
    public void setup() {
        reducer = new Reducer();
    }

    @After
    public void tearDown() {

    }


    @Test
    public void given_a_list_of_objects_should_roll_them_up_by_aggregating_values() {
        List<PerformanceData> performanceDataList = Arrays.asList(PerformanceData.builder()
                .bmv(100d).emv(120d).cash(23d).build(),
                PerformanceData.builder().bmv(150d).emv(175d).cash(30d).build(),
                PerformanceData.builder().bmv(130d).emv(150d).cash(40d).build());

        PerformanceData rolledUp = reducer.rollUp(performanceDataList);

        assertThat(rolledUp.getBmv(), equalTo(380d));
        assertThat(rolledUp.getEmv(), equalTo(445d));
        assertThat(rolledUp.getCash(), equalTo(93d));
    }

    @Test
    public void given_a_list_of_objects_should_roll_them_up_by_aggregating_values_with_a_collector() {
        List<PerformanceData> performanceDataList = Arrays.asList(PerformanceData.builder()
                        .bmv(100d).emv(120d).cash(23d).build(),
                PerformanceData.builder().bmv(150d).emv(175d).cash(30d).build(),
                PerformanceData.builder().bmv(130d).emv(150d).cash(40d).build());

        PerformanceData rolledUp = reducer.rollUpWithCollector(performanceDataList);

        assertThat(rolledUp.getBmv(), equalTo(380d));
        assertThat(rolledUp.getEmv(), equalTo(445d));
        assertThat(rolledUp.getCash(), equalTo(93d));
    }
}
