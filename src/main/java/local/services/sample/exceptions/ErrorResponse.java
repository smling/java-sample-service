package local.services.sample.exceptions;

import local.services.sample.Bases.BaseResponse;

public class ErrorResponse extends BaseResponse {

    public ErrorResponse(String code, String subject, RuntimeException exception) {
        super(code, subject, exception.getMessage());
    }
}
