package com.bbpos.tms2.services.sample.services;

import com.bbpos.tms2.services.sample.exceptions.SpecificKeywordException;
import org.springframework.stereotype.Service;

/**
 * Sample service
 */
@Service
public class SampleService {
    /**
     * Send back response.
     * @param message request message.
     * @return response message.
     */
    public String echo(String message) {
        if(message.equalsIgnoreCase("hello")) {
            throw new SpecificKeywordException(String.format("Keyword %s hit.", message));
        }
        return String.format("Server response: %s", message);
    }
}
