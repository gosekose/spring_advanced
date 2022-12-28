package hello.advanced.trace.strategy;

import hello.advanced.trace.strategy.code.v1.ContextV1;
import hello.advanced.trace.strategy.code.v1.Strategy;
import hello.advanced.trace.strategy.code.v1.StrategyLogic1;
import hello.advanced.trace.strategy.code.v2.ContextV2;
import hello.advanced.trace.template.code.AbstractTemplate;
import hello.advanced.trace.template.code.SubClassLogic1;
import hello.advanced.trace.template.code.SubClassLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV2Test {

    /**
     * 전략 패턴 사용
     */
    @Test
    public void strategyV1() throws Exception {
        //given
        StrategyLogic1 strategyLogic1 = new StrategyLogic1();

        // execute 행위에 대한 전략을 선택 하기 위해 생성자 생성
        ContextV1 contextV1 = new ContextV1(strategyLogic1);

        // 행위 실행
        contextV1.execute();
    }


    @Test
    public void strategyV2() throws Exception {
        //given
        Strategy logic1 = new Strategy() {

            @Override
            public void call() {
                log.info("비즈니스 로직1 실행");
            }
        };

        ContextV1 contextV1 = new ContextV1(logic1);

        log.info("StrategyLogic = {}", logic1.getClass());
        //when
        contextV1.execute();
        //then

    }

    /**
     * 전략 패턴 적용
     */
    @Test
    public void strategyV4() throws Exception {
        //given
        ContextV1 contextV1 = new ContextV1(() -> log.info("비즈니스 로직 실행1"));
        ContextV2 contextV2 = new ContextV2();

        contextV2.execute(new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직1");
            }
        });

        //when
        ContextV2 contextV21 = new ContextV2();

        contextV21.execute(() -> log.info("test"));


        //then
        
    }
}
