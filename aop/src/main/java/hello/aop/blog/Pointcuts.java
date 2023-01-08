package hello.aop.blog;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Pointcut;

@Slf4j
public class Pointcuts {

    @Pointcut("execution(* hello.aop.blog.*.save(..))")
    public void allSave() {}

    @Pointcut("execution(* hello.aop.blog.*.load(..))")
    public void allLoad() {}

    @Pointcut("execution(* hello.aop.blog.BlogService.*(..))")
    public void allService() {}

}
