package hello.advanced.proxy;

import hello.advanced.proxy.logtrace.LogTrace;
import hello.advanced.before.v2.OrderControllerV2;

public class OrderControllerConcreteProxy extends OrderControllerV2 {

    private final OrderControllerV2 target;
    private final LogTrace logTrace;

    public OrderControllerConcreteProxy(OrderControllerV2 target, LogTrace logTrace) {
        super(null);
        this.target = target;
        this.logTrace = logTrace;
    }
}
