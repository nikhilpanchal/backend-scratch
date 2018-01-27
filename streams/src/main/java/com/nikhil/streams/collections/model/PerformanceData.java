package com.nikhil.streams.collections.model;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class PerformanceData {
    private final double bmv;
    private final double emv;
    private final double cash;
}
