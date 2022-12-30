package hello.advanced;

import hello.advanced.callback.logtrace.LogTrace;
import hello.advanced.callback.logtrace.ThreadLocalTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {

    @Bean
    public LogTrace logTrace() {
        return new ThreadLocalTrace();
    }

}
