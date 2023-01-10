package hello.aop.internalcall;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CallServiceV2 {

    private final ObjectProvider<CallServiceV2> callServiceV2Provider;

    public CallServiceV2(ObjectProvider<CallServiceV2> callServiceV2Provider) {
        this.callServiceV2Provider = callServiceV2Provider;
    }

    public void external() {
        // 외부 메서드 추출
        log.info("call external");
        // provider에서 object 꺼낸 후, 지연 조회
        CallServiceV2 callServiceV2 = callServiceV2Provider.getObject();
        callServiceV2.internal();
    }

    public void internal() {
        log.info("call internal");
    }


//    @Bean
//    public CallServiceV2 callServiceV2(ApplicationContext context) {
//        return new CallServiceV2(context);
//    }
}
