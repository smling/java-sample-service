package local.services.sample.handlers;

import local.services.sample.exceptions.BaseWebServiceRuntimeException;
import local.services.sample.exceptions.ErrorResponse;
import local.services.sample.exceptions.SpecificKeywordException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ServiceExceptionHandler extends BaseExceptionHandler {
    @ExceptionHandler(value = {
        SpecificKeywordException.class
    })
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorResponse specificKeywordException(BaseWebServiceRuntimeException exception) {
        return new ErrorResponse("ERR-1001", "Specific keyword hit", exception);
    }
}
