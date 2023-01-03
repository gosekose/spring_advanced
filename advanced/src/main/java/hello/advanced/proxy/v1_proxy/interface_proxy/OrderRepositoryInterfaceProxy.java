package hello.advanced.proxy.v1_proxy.interface_proxy;

import hello.advanced.callback.logtrace.LogTrace;
import hello.advanced.callback.trace.TraceStatus;
import hello.advanced.proxy.v1.OrderRepositoryV1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
public class OrderRepositoryInterfaceProxy implements OrderRepositoryV1 {

    private final OrderRepositoryV1 target;
    private final LogTrace logTrace;

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
