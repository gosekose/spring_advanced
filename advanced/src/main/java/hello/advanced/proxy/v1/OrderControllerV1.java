package hello.advanced.proxy.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//@RequestMapping // 스프링 @Controller 또는 @RequestMapping이 있어야 컨트롤러로 인식
@ResponseBody
public interface OrderControllerV1 {

    @GetMapping("/api/v1/proxy/request")
    String request(@RequestParam("itemId") String itemId);

    @GetMapping("/api/v1/proxy/no-log")
    String noLog();

}
