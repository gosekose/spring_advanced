package hello.advanced.decorator.concrete;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConcreteLogic {

    public String operation() {
        log.info("ConcreteLogin 실행");
        return "data";
    }

}
