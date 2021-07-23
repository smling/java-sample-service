package com.bbpos.tms2.services.sample.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SampleServiceTest {
    private SampleService normalService;

    @BeforeAll
    void beforeAll() {
        normalService = new SampleService();
    }

    @ParameterizedTest()
    @MethodSource("echoTestSuccessData")
    void echoTest(String value) {
        Assertions.assertDoesNotThrow(()-> {
            String response = normalService.echo(value);
            Assertions.assertFalse(response.isEmpty());
        });
    }

    static Stream<Arguments> echoTestSuccessData() {
        return Stream.of(
                Arguments.arguments("test message"), Arguments.arguments("")
        );
    }
}
