package hello.advanced.config.postprocessor;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

@Slf4j
@RequiredArgsConstructor
public class PackageLogTracePostProcessor implements BeanPostProcessor {

    private final String basePackages;
    private final Advisor advisor;

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("param bearName = {} bean = {}", beanName, bean.getClass());

        // 프록시 적용 대상 여부 체크
        String packageName = bean.getClass().getPackageName();
        if (!packageName.startsWith(basePackages)) {
            return bean;
        }

        // 프록시 대상이면 프록시를 만들어서 반환
        ProxyFactory factory = new ProxyFactory(bean);
        factory.addAdvisor(advisor);

        Object proxy = factory.getProxy();
        log.info("create proxy: target = {}, proxt = {}", bean.getClass(), proxy.getClass());
        return proxy;

    }
}
