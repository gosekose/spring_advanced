package hello.advanced.proxy;

import hello.advanced.callback.logtrace.LogTrace;
import hello.advanced.proxy.v2.OrderRepositoryV2;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderRepositoryConcreteProxy extends OrderRepositoryV2 {

    private final OrderRepositoryV2 target;
    private final LogTrace trace;

    @Override
    public void save(String itemId) {

    }
}
