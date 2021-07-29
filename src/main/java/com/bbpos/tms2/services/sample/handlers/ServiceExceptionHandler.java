package com.bbpos.tms2.services.sample.handlers;

import com.bbpos.tms2.libs.web.exceptions.BaseWebServiceRuntimeException;
import com.bbpos.tms2.libs.web.handlers.BaseExceptionHandler;
import com.bbpos.tms2.libs.web.v1.dto.ErrorResponse;
import com.bbpos.tms2.services.sample.exceptions.SpecificKeywordException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ServiceExceptionHandler extends BaseExceptionHandler {
    @ExceptionHandler(value = {
        SpecificKeywordException.class
    })
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorResponse specificKeywordException(BaseWebServiceRuntimeException exception, HttpServletRequest request) {
        return new ErrorResponse(exception, request, "Specific keyword hit");
    }
}
