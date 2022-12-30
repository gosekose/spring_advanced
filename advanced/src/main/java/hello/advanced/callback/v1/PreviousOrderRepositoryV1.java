package hello.advanced.callback.v1;

import hello.advanced.callback.hellotrace.HelloTraceV1;
import hello.advanced.callback.trace.TraceStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PreviousOrderRepositoryV1 {

    private final HelloTraceV1 trace;

    public void save(String itemId) {

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
