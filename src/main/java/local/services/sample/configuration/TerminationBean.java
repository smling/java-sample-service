package local.services.sample.configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

@Component
public class TerminationBean {
    private final Logger logger = LogManager.getLogger(TerminationBean.class);

    @PreDestroy
    public void onDestroy() {
        logger.info("Service shutdown.");
    }
}
