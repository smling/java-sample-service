package com.bbpos.tms2.services.sample.services;

import com.bbpos.tms2.libs.web.v1.dto.CommandResponse;
import com.bbpos.tms2.services.sample.exceptions.SpecificKeywordException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * Sample service
 */
@Service
public class SampleService {
    private HttpServletRequest request;

    public SampleService(HttpServletRequest httpServletRequest) {
        this.request = httpServletRequest;
    }

    /**
     * Send back response.
     * @param message request message.
     * @return response message.
     */
    public CommandResponse echo(String message) {
        if(message.equalsIgnoreCase("hello")) {
            throw new SpecificKeywordException(String.format("Keyword %s hit.", message));
        }
        String responseMessage = String.format("Server response: %s", message);
        return new CommandResponse(responseMessage, request);
    }
}
