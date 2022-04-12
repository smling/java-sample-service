package local.services.sample.services;

import local.services.sample.exceptions.SpecificKeywordException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

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
    public CommandResponse echo(String message) {
        if(message.equalsIgnoreCase("hello")) {
            throw new SpecificKeywordException(String.format("Keyword %s hit.", message));
        }
        String responseMessage = String.format("Server response: %s", message);
        return new CommandResponse("0000", "Executed Success.", responseMessage);
    }
}
