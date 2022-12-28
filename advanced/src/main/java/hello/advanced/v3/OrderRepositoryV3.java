package hello.advanced.v3;

import hello.advanced.hellotrace.HelloTraceV2;
import hello.advanced.logtrace.LogTrace;
import hello.advanced.trace.TraceId;
import hello.advanced.trace.TraceStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV3 {

    private final LogTrace trace;

    public void save(TraceId traceId, String itemId) {

        TraceStatus status = null;

        try{
            status = trace.begin("OrderRepository.request{}");

            if (itemId.equals("ex")) {
                throw new IllegalStateException("에러 발생!");
            }

            doSleep(1000);
            trace.end(status);

        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }

    private void doSleep(int mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
