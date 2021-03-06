package local.services.sample.handlers;

import local.services.sample.exceptions.BaseWebServiceRuntimeException;
import local.services.sample.exceptions.SpecificKeywordException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.http.HttpServletRequest;
import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ServiceExceptionHandlerTest {
    @Mock
    HttpServletRequest httpServletRequest;

    private ServiceExceptionHandler serviceExceptionHandler;

    @BeforeEach
    void beforeEach() {
        MockitoAnnotations.openMocks(this);
        serviceExceptionHandler = new ServiceExceptionHandler();
    }

    @ParameterizedTest()
    @MethodSource("specificKeywordExceptionTestSuccessData")
    void specificKeywordExceptionTest(BaseWebServiceRuntimeException exception) {
        Assertions.assertDoesNotThrow(()->{
            serviceExceptionHandler.specificKeywordException(exception);
        });
    }

    static Stream<Arguments> specificKeywordExceptionTestSuccessData() {
        return Stream.of(
                Arguments.arguments(new SpecificKeywordException("Dummy message."))
        );
    }
}
