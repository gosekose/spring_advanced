package hello.advanced.jdkdynamic.cglib;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

@RequiredArgsConstructor
@Slf4j
public class TimeMethodInterceptor implements MethodInterceptor {

    private final Object target;


//    @Override
//    public Object invoke(MethodInvocation invocation) throws Throwable {
//        log.info("TimeProxy 실행");
//        long startTime = System.currentTimeMillis();
//
//        Object result = method.invoke(target, args);
//
//        long endTime = System.currentTimeMillis();
//        long resultTime = endTime - startTime;
//        log.info("TimeProxy 종료 resultTime", resultTime);
//        return result;
//    }


    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

        log.info("TimeProxy 실행");
        long startTime = System.currentTimeMillis();

        Object result = methodProxy.invoke(target, args);

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("TimeProxy 종료 resultTime", resultTime);
        return result;

    }
}
