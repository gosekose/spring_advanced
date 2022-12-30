package hello.advanced.callback.v2;

import hello.advanced.callback.hellotrace.HelloTraceV2;
import hello.advanced.callback.trace.TraceStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/previous")
@RequiredArgsConstructor
public class PreviousOrderControllerV2 {

    private final PreviousOrderServiceV2 orderService;
    private final HelloTraceV2 trace;

    @GetMapping("/v2/request")
    public String request(String itemId) {

        TraceStatus status = null;

        try{
            status = trace.begin("OrderControllerV2.request{}");
            orderService.orderItem(status.getTraceId(), itemId);
            trace.end(status);
            return "ok";
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }
}
