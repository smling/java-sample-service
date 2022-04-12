package local.services.sample.services;

import local.services.sample.bases.BaseResponse;

public class CommandResponse extends BaseResponse {
    public CommandResponse(String code, String subject, String message) {
        super(code, subject, message);
    }
}
