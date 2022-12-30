package hello.advanced.callback.v4;

import hello.advanced.callback.logtrace.LogTrace;
import hello.advanced.callback.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PreviousOrderServiceV4 {

    private final PreviousOrderRepositoryV4 orderRepository;
    private final LogTrace trace;

    public void orderItem(String itemId) {

        AbstractTemplate<Void> template = new AbstractTemplate<Void>(trace) {
            @Override
            protected Void call() {
                orderRepository.save(itemId);
                return null;
            }
        };
        template.execute("OrderControllerV2.request()");
    }
}
