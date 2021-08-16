package com.bbpos.tms2.services.sample.health.indicators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SampleHealthIndicatorTest {
    @Test
    void constructorTest() {
        Assertions.assertDoesNotThrow(()->{
            SampleHealthIndicator sampleHealthIndicator = new SampleHealthIndicator();
            Assertions.assertNotNull(sampleHealthIndicator.health());
            Assertions.assertNotNull(sampleHealthIndicator.getHealth(true));
        });
    }
}
