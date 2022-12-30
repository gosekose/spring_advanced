package hello.advanced.callback.template;

import hello.advanced.callback.logtrace.LogTrace;
import hello.advanced.callback.trace.TraceStatus;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractTemplate<T> {

    private final LogTrace trace;

    public AbstractTemplate(LogTrace trace) {
        this.trace = trace;
    }

    public T execute(String message) {
        TraceStatus status = null;
        try {
            status = trace.begin(message);

            T result = call() ;

            trace.end(status);
            return result;

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    protected abstract T call();
}