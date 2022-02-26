package local.services.sample.exceptions;

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
