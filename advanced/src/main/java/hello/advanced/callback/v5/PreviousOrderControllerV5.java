package hello.advanced.callback.v5;

import hello.advanced.callback.logtrace.LogTrace;
import hello.advanced.callback.trace.callback.TraceTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/previous")
public class PreviousOrderControllerV5 {

    private final PreviousOrderServiceV5 orderService;
    private final TraceTemplate template;

    public PreviousOrderControllerV5(PreviousOrderServiceV5 orderService, LogTrace trace) {
        this.orderService = orderService;
        this.template = new TraceTemplate(trace);
    }

    @GetMapping("/v5/request")
    public String request(String itemId) {
        return template.execute("OrderControllerV2.request()", () -> {
            orderService.orderItem(itemId);
            return "ok";
        });
    }
}
