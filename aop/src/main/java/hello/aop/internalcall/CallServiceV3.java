package hello.aop.internalcall;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 구조를 분리
 *
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class CallServiceV3 {


    // 내부 호풀을 인터널 클래스로 구조 자체를 바꾼다
    private final InternalService internalService;

    public void external() {
        log.info("call external");
        internalService.internal();
    }

}
