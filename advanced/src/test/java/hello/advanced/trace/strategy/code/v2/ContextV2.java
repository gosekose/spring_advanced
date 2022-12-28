package hello.advanced.trace.strategy.code.v2;

import hello.advanced.trace.strategy.code.v1.Strategy;
import lombok.extern.slf4j.Slf4j;

/**
 * 전략을 파라미터로 전달 받는 방식
 *
 */
@Slf4j
public class ContextV2 {

    public void execute(Strategy strategy) {
        long startTime = System.currentTimeMillis();

        strategy.call();

        log.info("비즈니스 로직1 실행");
        long endTime =  System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime = {}", resultTime);
    }
}
