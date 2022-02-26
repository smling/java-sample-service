package local.services.sample.exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SpecificKeywordExceptionTest {
    @ParameterizedTest()
    @MethodSource("echoTestSuccessData")
    void constructorTest(String message, boolean isSuccessExpected) {
        if(isSuccessExpected) {
            Assertions.assertDoesNotThrow(() -> {
                SpecificKeywordException exception = new SpecificKeywordException(message);
                Assertions.assertNotNull(exception);
                SpecificKeywordException exceptionWithInnerException = new SpecificKeywordException(message, new RuntimeException());
                Assertions.assertNotNull(exceptionWithInnerException);
            });
        } else {
            Assertions.assertThrows(Exception.class, () -> new SpecificKeywordException(message));
        }
    }

    static Stream<Arguments> echoTestSuccessData() {
        return Stream.of(
                Arguments.arguments("message", true),
                Arguments.arguments("", false)
        );
    }
}
