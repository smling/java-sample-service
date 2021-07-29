package com.bbpos.tms2.services.sample.exceptions;

import com.bbpos.tms2.libs.web.exceptions.BaseWebServiceRuntimeException;
import com.bbpos.tms2.libs.web.exceptions.NullParameterException;

import java.util.Objects;

/**
 * Specific keyword exception.
 */
public class SpecificKeywordException extends BaseWebServiceRuntimeException {

    public SpecificKeywordException(String message) {
        super(message);
    }

    protected SpecificKeywordException(String message, Exception exception) {
        super(message, exception);
    }

    @Override
    public String getErrorCode() {
        return "TMP-40001";
    }
}
