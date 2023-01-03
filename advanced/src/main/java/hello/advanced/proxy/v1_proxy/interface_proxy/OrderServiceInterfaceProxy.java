package hello.advanced.proxy.v1_proxy.interface_proxy;

import hello.advanced.callback.logtrace.LogTrace;
import hello.advanced.callback.trace.TraceStatus;
import hello.advanced.proxy.v1.OrderRepositoryV1;
import hello.advanced.proxy.v1.OrderServiceV1;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderServiceInterfaceProxy implements OrderServiceV1 {

    private final OrderServiceV1 target;
    private final LogTrace logTrace;


    @Override
    public void orderItem(String itemId) {
        TraceStatus status = null;
        try{
            status = logTrace.begin("OrderService.orderItem.request");
            target.orderItem(itemId);
            logTrace.end(status);
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }
}
