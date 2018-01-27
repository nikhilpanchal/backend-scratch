package com.nikhil.streams.collections;

import com.nikhil.streams.collections.agggregators.PerformanceDataAggregator;
import com.nikhil.streams.collections.agggregators.PerformanceDataCollector;
import com.nikhil.streams.collections.model.PerformanceData;

import java.util.List;

public class Reducer {

    public PerformanceData rollUp(List<PerformanceData> performanceDataList) {
        return performanceDataList.stream()
                .collect(PerformanceDataAggregator::new, PerformanceDataAggregator::accumulate, PerformanceDataAggregator::merge)
                .getData();
    }

    public PerformanceData rollUpWithCollector(List<PerformanceData> performanceDataList) {
        return performanceDataList.stream()
                .collect(new PerformanceDataCollector());
    }
}
