package hello.aop.order;

import hello.aop.order.aop.*;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Slf4j
//@Import(AspectV4Pointcut.class)
//@Import({AspectV5Order.LogAspect.class, AspectV5Order.TransactionLogAspect.class})
@Import(AspectV6Advice.class)
@SpringBootTest
public class AopTest {

    @Autowired
    OrderService orderService;

    @Autowired
    OrderRepository orderRepository;

    @Test
    public void aopInfo() throws Exception {
        //given
        log.info("isAopProxy orderService={}", AopUtils.isAopProxy(orderService));
        log.info("isAopProxy orderRepository={}", AopUtils.isAopProxy(orderRepository));
    }

    @Test
    public void success() throws Exception {

        orderService.orderItem("itemA");

    }

    @Test
    void exception() {
        Assertions.assertThatThrownBy(() -> orderService.orderItem("ex"))
                .isInstanceOf(IllegalStateException.class);
    }

}
