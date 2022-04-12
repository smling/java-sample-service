package local.services.sample.v1.controllers;

import local.services.sample.bases.BaseResponse;
import local.services.sample.services.SampleService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;
import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SampleControllerTest {
    private SampleController normalController;

    @BeforeAll
    void beforeAll() {
        normalController = new SampleController(new SampleService());
    }

    @Test
    void constructorTest() {
        Assertions.assertAll(()-> Assertions.assertDoesNotThrow(()-> {
            SampleController sampleController = new SampleController(new SampleService());
            Assertions.assertNotNull(sampleController);
        }));
    }

    @ParameterizedTest()
    @MethodSource("echoTestSuccessData")
    void echoTest(String value) {
        Assertions.assertDoesNotThrow(()-> {
            BaseResponse response = normalController.echo(value);
            Assertions.assertTrue(Objects.nonNull(response));
        });
    }

    static Stream<Arguments> echoTestSuccessData() {
        return Stream.of(
            Arguments.arguments("test message"), Arguments.arguments("")
        );
    }
}
