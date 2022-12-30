package hello.advanced.callback.v2;

import hello.advanced.callback.hellotrace.HelloTraceV2;
import hello.advanced.callback.trace.TraceId;
import hello.advanced.callback.trace.TraceStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PreviousOrderServiceV2 {

    private final PreviousOrderRepositoryV2 orderRepository;
    private final HelloTraceV2 trace;

    public void orderItem(TraceId traceId, String itemId) {

        TraceStatus status = null;

        try{
            status = trace.beginSync(traceId, "OrderService.request{}");
            orderRepository.save(status.getTraceId(), itemId);
            trace.end(status);

        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }
}
