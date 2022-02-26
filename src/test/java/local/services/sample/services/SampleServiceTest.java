package local.services.sample.services;

import local.services.sample.exceptions.SpecificKeywordException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;
import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SampleServiceTest {
    private SampleService normalService;
    private final HttpServletRequest mockedRequest = Mockito.mock(HttpServletRequest.class);
    @BeforeAll
    void beforeAll() {
        normalService = new SampleService(mockedRequest);
    }

    @ParameterizedTest()
    @MethodSource("echoTestSuccessData")
    void echoTestSuccess(String value) {
        Assertions.assertDoesNotThrow(()-> {
            CommandResponse response = normalService.echo(value);
            Assertions.assertTrue(Objects.nonNull(response));
        });
    }

    @ParameterizedTest()
    @MethodSource("echoTestFailureData")
    void echoTestFailure(String value) {
        Assertions.assertThrows(SpecificKeywordException.class, ()-> normalService.echo(value));
    }

    static Stream<Arguments> echoTestSuccessData() {
        return Stream.of(
                Arguments.arguments("test message"), Arguments.arguments("")
        );
    }

    static Stream<Arguments> echoTestFailureData() {
        return Stream.of(
                Arguments.arguments("hello")
        );
    }
}
