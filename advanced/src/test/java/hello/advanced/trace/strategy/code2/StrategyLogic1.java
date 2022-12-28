package hello.advanced.trace.strategy.code2;

public class StrategyLogic1 implements Strategy {

    // 전략 첫 번째
    @Override
    public void execute() {
        System.out.println("전략 1번을 사용합니다.");
    }
}
