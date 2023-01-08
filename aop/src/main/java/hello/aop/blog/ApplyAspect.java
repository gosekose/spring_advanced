package hello.aop.blog;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
public class ApplyAspect {

//    @Order(1)
    @Aspect
    public static class AllSave {
        @Around("hello.aop.blog.Pointcuts.allSave()")
        public Object saveAround(ProceedingJoinPoint joinPoint) throws Throwable {

            try{

                log.info("[Around AllSave ProceedingJoinPoint]");
                Object result = joinPoint.proceed();
                log.info("[Around AllSave ProceedingJoinPoint] result = {}", result);

                return result;

            } catch (Exception e) {

                log.info("[Around AllSave Exception] message = {}", e.getMessage());
                throw e;
            }

        }
    }

//    @Order(1)
    @Aspect
    public static class AllLoad {

        @Before("hello.aop.blog.Pointcuts.allLoad()")
        public void loadBefore(JoinPoint joinPoint) throws Throwable {
            log.info("[Before AllLoad JoinPoint]");
        }

        @AfterReturning(value = "hello.aop.blog.Pointcuts.allLoad()", returning = "result")
        public void loadReturn(JoinPoint joinPoint, Object result) {
            log.info("[AfterReturning AllLoad joinPoint] Signature = {}", joinPoint.getSignature());
            log.info("[AfterReturning AllLoad joinPoint] Target = {}", joinPoint.getTarget());
            log.info("[AfterReturning AllLoad joinPoint] Args = {}", joinPoint.getArgs());
            log.info("[AfterReturning AllLoad joinPoint] This = {}", joinPoint.getThis());
            log.info("[AfterReturning AllLoad joinPoint] Kind = {}", joinPoint.getKind());
            log.info("[AfterReturning AllLoad joinPoint] StaticPart = {}", joinPoint.getStaticPart());
            log.info("[AfterReturning AllLoad joinPoint] SourceLocation = {}", joinPoint.getSourceLocation());
            log.info("[AfterReturning AllLoad joinPoint] class = {}", joinPoint.getClass());
            log.info("[AfterReturning AllLoad Result] result = {}", result.toString());
        }

        @AfterThrowing(value = "hello.aop.blog.Pointcuts.allLoad()", throwing = "e")
        public void loadThrowing(JoinPoint joinPoint, Exception e) {
            log.info("[AfterThrowing AllLoad Exception] message = {}", e);
        }

        @After(value = "hello.aop.blog.Pointcuts.allLoad()")
        public void loadAfter(JoinPoint joinPoint) {
            log.info("[After AllLoad joinPoint] Signature = {}", joinPoint.getSignature());
        }
    }

//    @Order(2)
    @Aspect
    public static class AllService {

        @Around("hello.aop.blog.Pointcuts.allService()")
        public Object saveAndLoadAround(ProceedingJoinPoint joinPoint) throws  Throwable {

            try{

                log.info("[Around AllService ProceedingJoinPoint]");
                Object result = joinPoint.proceed();

                log.info("[Around AllService ProceedingJoinPoint] result = {}", result);
                log.info("[Around AllService ProceedingJoinPoint] class = {}", joinPoint.getClass());

                return result;

            } catch (Exception e) {

                log.info("[Around AllService Exception] message = {}", e.getMessage());
                throw e;
            }
        }
    }
}
