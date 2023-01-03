package hello.advanced.proxy.v3.advice;

import hello.advanced.callback.logtrace.LogTrace;
import hello.advanced.callback.trace.TraceStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

@RequiredArgsConstructor
@Slf4j
public class LogTraceAdvice implements MethodInterceptor {

    private final LogTrace logTrace;

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        TraceStatus status = null;

        try {
            Method method = invocation.getMethod();
            log.info("invocation.getThis() = {}", invocation.getThis());
            log.info("invocation.getArguments() = {}", invocation.getArguments());
            log.info("invocation.getStaticPart() = {}", invocation.getStaticPart());
            log.info("invocation.getMethod() = {}", invocation.getMethod());

            String message = method.getDeclaringClass().getSimpleName() + "." + method.getName() + "()";
            status = logTrace.begin(message);

            Object result = invocation.proceed();

            logTrace.end(status);
            return result;
        } catch (Exception e) {
            logTrace.exception(status, e);
        }

        return null;
    }
}
