package local.services.sample.Bases;

public abstract class BaseResponse {
    protected String code;
    protected String subject;
    protected String message;

    public BaseResponse(String code, String subject, String message) {
        this.code = code;
        this.subject = subject;
        this.message = message;
    }
}
