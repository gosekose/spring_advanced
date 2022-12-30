package hello.advanced.callback.v5;

import hello.advanced.callback.trace.callback.TraceTemplate;
import hello.advanced.callback.logtrace.LogTrace;
import org.springframework.stereotype.Service;

@Service
public class PreviousOrderServiceV5 {

    private final PreviousOrderRepositoryV5 orderRepository;
    private final TraceTemplate template;

    public PreviousOrderServiceV5(PreviousOrderRepositoryV5 orderRepository, LogTrace trace) {
        this.orderRepository = orderRepository;
        this.template = new TraceTemplate(trace);
    }

    public void orderItem(String itemId) {
        template.execute("OrderControllerV2.request()", () -> {
            orderRepository.save(itemId);
            return null;
        });
    }
}
