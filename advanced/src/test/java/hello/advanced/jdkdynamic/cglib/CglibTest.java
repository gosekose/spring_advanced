package hello.advanced.jdkdynamic.cglib;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;

@Slf4j
public class CglibTest {


    @Test
    public void cglib() throws Exception {
        //given
        ConcreteService target = new ConcreteService();


        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ConcreteService.class);
        enhancer.setCallback(new TimeMethodInterceptor(target));
        ConcreteService proxy = (ConcreteService) enhancer.create();

        log.info("targetClass = {}", target.getClass());
        log.info("proxyClass = {}", target.getClass());

        proxy.call();
    }
}
