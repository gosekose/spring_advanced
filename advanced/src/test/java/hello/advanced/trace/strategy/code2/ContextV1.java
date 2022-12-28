package hello.advanced.trace.strategy.code2;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class ContextV1 {

    private Strategy strategy;

    // execute를 strategy에 위임
    public void execute() {
        strategy.execute();
    }
}

