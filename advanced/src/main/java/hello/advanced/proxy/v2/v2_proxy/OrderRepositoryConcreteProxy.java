package hello.advanced.proxy.v2.v2_proxy;

import hello.advanced.callback.logtrace.LogTrace;
import hello.advanced.callback.trace.TraceStatus;
import hello.advanced.proxy.v2.OrderRepositoryV2;

public class OrderRepositoryConcreteProxy extends OrderRepositoryV2 {

    private final OrderRepositoryV2 target;
    private final LogTrace logTrace;

    public OrderRepositoryConcreteProxy(OrderRepositoryV2 target, LogTrace logTrace) {
        this.target = target;
        this.logTrace = logTrace;
    }

    @Override
    public void save(String itemId) {
        TraceStatus status = null;
        try{
            status = logTrace.begin("OrderRepository.request");
            target.save(itemId);
            logTrace.end(status);
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }
}
