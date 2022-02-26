package local.service.sample.services.sample.exceptions;

public abstract class BaseWebServiceRuntimeException extends RuntimeException {
    public BaseWebServiceRuntimeException(String message) {
        super(message);
    }

    public BaseWebServiceRuntimeException(Exception exception) {
        super(exception);
    }

    public BaseWebServiceRuntimeException(String message, Exception exception) {
        super(message, exception);
    }

    public abstract String getErrorCode();
}
