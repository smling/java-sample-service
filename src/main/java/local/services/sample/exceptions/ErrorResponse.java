package local.service.sample.services.sample.exceptions;

import javax.servlet.http.HttpServletRequest;

public class ErrorResponse {
    private String code;
    private String subject;
    private String message;

    public ErrorResponse(String code, String subject, RuntimeException exception) {
        this.code = code;
        this.subject = subject;
        this.message = exception.getMessage();
    }
}
