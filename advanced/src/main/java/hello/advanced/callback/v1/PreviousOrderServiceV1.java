package hello.advanced.callback.v1;

import hello.advanced.callback.hellotrace.HelloTraceV1;
import hello.advanced.proxy.trace.TraceStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PreviousOrderServiceV1 {

    private final PreviousOrderRepositoryV1 orderRepository;
    private final HelloTraceV1 trace;

    public void orderItem(String itemId) {

        TraceStatus status = null;

        try{
            status = trace.begin("OrderService.request{}");
            orderRepository.save(itemId);
            trace.end(status);

        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }
}
