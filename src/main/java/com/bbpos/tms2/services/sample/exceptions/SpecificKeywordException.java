package com.bbpos.tms2.services.sample.exceptions;

/**
 * Specific keyword exception.
 */
public class SpecificKeywordException extends RuntimeException {
    public SpecificKeywordException(String message) {
        super(message);
        if(message.isEmpty())
            throw new IllegalArgumentException("Message could not be empty.");
    }
}
