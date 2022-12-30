package hello.advanced.callback.v1;

import hello.advanced.callback.hellotrace.HelloTraceV1;
import hello.advanced.callback.trace.TraceStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/previous")
@RequiredArgsConstructor
public class PreviousOrderControllerV1 {

    private final PreviousOrderServiceV1 orderService;
    private final HelloTraceV1 trace;

    @GetMapping("/v1/request")
    public String request(String itemId) {

        TraceStatus status = null;

        try{
            status = trace.begin("OrderControllerV2.request{}");
            orderService.orderItem(itemId);
            trace.end(status);
            return "ok";
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }
}
