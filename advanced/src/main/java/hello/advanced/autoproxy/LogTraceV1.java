package hello.advanced.autoproxy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LogTraceV1 {

    public void doLog(String message) {
        log.info("method = {}", message);
    }
}
