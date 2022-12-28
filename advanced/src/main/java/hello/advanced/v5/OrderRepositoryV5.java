package hello.advanced.v5;

import hello.advanced.logtrace.LogTrace;
import hello.advanced.template.AbstractTemplate;
import hello.advanced.trace.callback.TraceTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryV5 {

    private final TraceTemplate template;

    public OrderRepositoryV5 (LogTrace trace) {
        this.template = new TraceTemplate(trace);
    }

    public void save(String itemId) {

        template.execute("OrderRepository.save()", () ->{
            if (itemId.equals("ex")) {
                throw new IllegalStateException("에러 발생!");
            }

            doSleep(500);
            
            return null;
        });
    }

    private void doSleep(int mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}