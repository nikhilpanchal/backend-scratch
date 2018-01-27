package com.nikhil.streams.collections.agggregators;

import com.nikhil.streams.collections.model.PerformanceData;
import lombok.Data;

@Data
public class PerformanceDataAggregator {
    private PerformanceData data;

    public PerformanceDataAggregator() {
        this.data = PerformanceData.builder().build();
    }

    public void accumulate(PerformanceData data) {
        this.data = addPerformanceData(data);
    }

    private PerformanceData addPerformanceData(PerformanceData data) {
        return PerformanceData.builder()
                .bmv(this.data.getBmv() + data.getBmv())
                .emv(this.data.getEmv() + data.getEmv())
                .cash(this.data.getCash() + data.getCash())
                .build();
    }

    public void merge(PerformanceDataAggregator agg) {
        this.data = addPerformanceData(agg.getData());
    }

    public PerformanceDataAggregator combine(PerformanceDataAggregator agg) {
        merge(agg);

        return this;
    }
}
