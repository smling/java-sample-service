package local.services.sample.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {
    @Bean
    public TerminationBean getTerminateBean() {
        return new TerminationBean();
    }
}
