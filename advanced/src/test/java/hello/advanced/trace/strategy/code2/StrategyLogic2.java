package hello.advanced.trace.strategy.code2;

public class StrategyLogic2 implements Strategy {

    // 전략 두 번째
    @Override
    public void execute() {
        System.out.println("전략 2번을 사용합니다.");
    }
}
