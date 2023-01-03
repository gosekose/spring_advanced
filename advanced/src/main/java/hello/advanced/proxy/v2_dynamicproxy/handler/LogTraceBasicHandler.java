package hello.advanced.proxy.v2_dynamicproxy.handler;

import hello.advanced.callback.logtrace.LogTrace;
import hello.advanced.callback.trace.TraceStatus;
import lombok.RequiredArgsConstructor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@RequiredArgsConstructor
public class LogTraceBasicHandler implements InvocationHandler {

    private final Object target;
    private final LogTrace logTrace;

    @Override
    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
        TraceStatus status = null;
        try{
            String message = method.getDeclaringClass().getSimpleName() + "." +
                    method.getName() + "()";
            status = logTrace.begin(message);

            // 로직 호출하기
            Object result = method.invoke(target, args);
            logTrace.end(status);
            return result;
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }
}
