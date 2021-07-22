package com.bbpos.tms2.services.sample.v1.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SampleControllerTest {
    private SampleController normalController;

    @BeforeAll
    void beforeAll() {
        normalController = new SampleController();
    }

    @ParameterizedTest()
    @MethodSource("getTestSuccessData")
    void getTest(String value) {
        Assertions.assertDoesNotThrow(()-> {
            String response = normalController.get(value);
            Assertions.assertFalse(response.isEmpty());
        });
    }

    static Stream<Arguments> getTestSuccessData() {
        return Stream.of(
            Arguments.arguments("test message"), Arguments.arguments("")
        );
    }
}
