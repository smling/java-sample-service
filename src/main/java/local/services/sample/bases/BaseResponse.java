package local.services.sample.bases;

public abstract class BaseResponse {
    protected String code;
    protected String subject;
    protected String message;

    protected BaseResponse(String code, String subject, String message) {
        this.code = code;
        this.subject = subject;
        this.message = message;
    }
}
