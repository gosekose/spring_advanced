package hello.advanced.trace.strategy;

import hello.advanced.trace.strategy.code.v1.ContextV1;
import hello.advanced.trace.strategy.code.v1.Strategy;
import hello.advanced.trace.strategy.code.v1.StrategyLogic1;
import hello.advanced.trace.template.code.AbstractTemplate;
import hello.advanced.trace.template.code.SubClassLogic1;
import hello.advanced.trace.template.code.SubClassLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV1Test {

    @Test
    public void strategyV0() throws Exception {
        logic1();
        logic2();
    }

    private void logic1() {
        long startTime = System.currentTimeMillis();

        log.info("비즈니스 로직1 실행");
        long endTime =  System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime = {}", resultTime);
    }

    private void logic2() {
        long startTime = System.currentTimeMillis();

        log.info("비즈니스 로직2 실행");
        long endTime =  System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime = {}", resultTime);
    }

    /**
     * 템플릿 메소드 패턴 적용
     */
    @Test
    public void 템플릿_메소드_적용_1() throws Exception {

        AbstractTemplate template1 = new SubClassLogic1();
        template1.execute();

        AbstractTemplate template2 = new SubClassLogic2();
        template2.execute();

        //then
    }


    /**
     * 템플릿 메소드 패턴 적용
     */
    @Test
    public void 템플릿_메소드_적용_2() throws Exception {

        AbstractTemplate template1 = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("비즈니스 로직1 실행");
            }
        };

        //then
        template1.execute();

        AbstractTemplate template2 = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("비즈니스 로직2 실행");
            }
        };

        //then
        template2.execute();
    }


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
    
    @Test
    public void strategyV4() throws Exception {
        //given
        ContextV1 contextV1 = new ContextV1(() -> log.info("비즈니스 로직 실행1"));

        //when
        
        //then
        
    }
}
