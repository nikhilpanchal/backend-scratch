package com.nikhil.streams.collections.agggregators;

import com.nikhil.streams.collections.model.PerformanceData;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class PerformanceDataCollector implements Collector<PerformanceData, PerformanceDataAggregator, PerformanceData> {

    @Override
    public Supplier<PerformanceDataAggregator> supplier() {
        return PerformanceDataAggregator::new;
    }

    @Override
    public BiConsumer<PerformanceDataAggregator, PerformanceData> accumulator() {
        return PerformanceDataAggregator::accumulate;
    }

    @Override
    public BinaryOperator<PerformanceDataAggregator> combiner() {
        return PerformanceDataAggregator::combine;
    }

    @Override
    public Function<PerformanceDataAggregator, PerformanceData> finisher() {
        return PerformanceDataAggregator::getData;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return new HashSet<Characteristics>();
    }
}
