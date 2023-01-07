package hello.advanced.autoproxy;

import lombok.RequiredArgsConstructor;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

@RequiredArgsConstructor
public class LogTraceV1Advice implements MethodInterceptor {

    private final LogTraceV1 logTraceV1;

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        try {

            Method method = invocation.getMethod();
            String message = method.getDeclaringClass().getSimpleName() + "." + method.getName() + "()";
            logTraceV1.doLog(message);

            Object result = invocation.proceed();

            return result;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
