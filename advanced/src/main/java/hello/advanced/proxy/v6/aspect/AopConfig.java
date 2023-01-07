package hello.advanced.proxy.v6.aspect;

import hello.advanced.proxy.logtrace.LogTrace;
import hello.advanced.config.AppV2Config;
import hello.advanced.proxy.logtrace.ThreadLocalTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.Order;

@Configuration
public class AopConfig {

//    @Bean
//    public LogTraceAspect logTraceAspect(LogTrace logTrace) {
//        return new LogTraceAspect(logTrace);
//    }


}
