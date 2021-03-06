package local.services.sample.exceptions;

import org.apache.commons.lang.StringUtils;

public abstract class BaseWebServiceRuntimeException extends RuntimeException {
    protected BaseWebServiceRuntimeException(String message) {
        super(message);
        if(StringUtils.isEmpty(message.trim()))
            throw new IllegalArgumentException("Message could not be null or empty.");
    }


    protected BaseWebServiceRuntimeException(String message, Exception exception) {
        super(message, exception);
    }

    public abstract String getErrorCode();
}
