package com.bbpos.tms2.services.sample.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class OpenApiConfigurationTest {
    private final OpenApiConfiguration openApiConfiguration=new OpenApiConfiguration();

    @ParameterizedTest()
    @MethodSource("echoTestSuccessData")
    void echoTest(String name, String description) {
        Assertions.assertDoesNotThrow(()-> {
            OpenAPI response = openApiConfiguration.customOpenAPI(name, description);
            Assertions.assertNotNull(response);
        });
    }

    static Stream<Arguments> echoTestSuccessData() {
        return Stream.of(
                Arguments.arguments("test service", "test service description."),
                Arguments.arguments("", "")
        );
    }
}
