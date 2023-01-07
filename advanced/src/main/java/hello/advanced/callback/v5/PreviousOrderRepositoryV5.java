package hello.advanced.callback.v5;

import hello.advanced.proxy.trace.callback.TraceTemplate;
import hello.advanced.proxy.logtrace.LogTrace;
import org.springframework.stereotype.Repository;

@Repository
public class PreviousOrderRepositoryV5 {

    private final TraceTemplate template;

    public PreviousOrderRepositoryV5(LogTrace trace) {
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
