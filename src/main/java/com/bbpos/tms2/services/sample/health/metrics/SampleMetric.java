package com.bbpos.tms2.services.sample.health.metrics;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class SampleMetric {
    private final AtomicInteger value;

    public SampleMetric(MeterRegistry meterRegistry) {
        value=meterRegistry.gauge("sample.metric", new AtomicInteger());
    }

    public void updateValue(int value) {
        if(Objects.nonNull(this.value))
            this.value.set(value);
    }
}
