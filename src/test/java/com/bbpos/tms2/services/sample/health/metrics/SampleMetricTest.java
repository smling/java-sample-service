package com.bbpos.tms2.services.sample.health.metrics;

import com.bbpos.tms2.services.sample.exceptions.SpecificKeywordException;
import io.micrometer.core.instrument.MeterRegistry;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SampleMetricTest {
    private SampleMetric sampleMetric;

    @Mock
    MeterRegistry meterRegistry;

    @BeforeAll
    void beforeAll() {
        MockitoAnnotations.openMocks(this);
        sampleMetric = new SampleMetric(meterRegistry);
    }

    @ParameterizedTest(name = "Assign value {0} to metric.")
    @MethodSource("updateValueTestSuccessData")
    void updateValueTestSuccess(int value) {
        Assertions.assertDoesNotThrow(()-> sampleMetric.updateValue(value));
    }

    static Stream<Arguments> updateValueTestSuccessData() {
        return Stream.of(
                Arguments.arguments(1),
                Arguments.arguments(0),
                Arguments.arguments(-1)
        );
    }
}
