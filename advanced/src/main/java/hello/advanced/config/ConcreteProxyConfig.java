package hello.advanced.config;

import hello.advanced.proxy.logtrace.LogTrace;
import hello.advanced.before.v2.OrderControllerV2;
import hello.advanced.before.v2.OrderRepositoryV2;
import hello.advanced.before.v2.OrderServiceV2;
import hello.advanced.before.v2.v2_proxy.OrderControllerConcreteProxy;
import hello.advanced.before.v2.v2_proxy.OrderRepositoryConcreteProxy;
import hello.advanced.before.v2.v2_proxy.OrderServiceConcreteProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConcreteProxyConfig {

    @Bean
    public OrderRepositoryV2 orderRepositoryV2(LogTrace logTrace) {
        OrderRepositoryV2 repositoryImpl = new OrderRepositoryV2();
        return new OrderRepositoryConcreteProxy(repositoryImpl, logTrace);
    }

    @Bean
    public OrderServiceV2 orderServiceV2(LogTrace logTrace) {
        OrderServiceV2 serviceImpl = new OrderServiceV2(orderRepositoryV2(logTrace));
        return new OrderServiceConcreteProxy(serviceImpl, logTrace);
    }

    @Bean
    public OrderControllerV2 orderControllerV2(LogTrace logTrace) {
        OrderControllerV2 controllerImpl = new OrderControllerV2(orderServiceV2(logTrace));
        return new OrderControllerConcreteProxy(controllerImpl, logTrace);
    }

}
