package hello.aop.order.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Slf4j
@Aspect
public class AspectV6Advice {

//    @Around("hello.aop.order.aop.Pointcuts.allOrder()")
//    public Object doLog(ProceedingJoinPoint joinPoint) throws Throwable {
//        log.info("[log] {}", joinPoint.getSignature());
//        return joinPoint.proceed();
//    }
//
//    //hello.aop.order 패키지와 하위 패키지 이면서, 동ㅅ에 클래스 패턴 이름이 *Service
//    @Around("hello.aop.order.aop.Pointcuts.orderAndService()")
//    public Object doTransaction(ProceedingJoinPoint joinPoint) throws Throwable {
//
//        try{
//
//            //@Before
//            log.info("[트랜잭션 시작] {}", joinPoint.getSignature());
//            Object result = joinPoint.proceed();
//
//            //@AfterReturning
//            log.info("[트랜잭션 커밋] {}", joinPoint.getSignature());
//            return result;
//
//        } catch (Exception e) {
//
//            //@AfterThrowing
//            log.info("[트랜잭션 롤백] {}", joinPoint.getSignature());
//            throw e;
//        } finally {
//
//            //@After
//            log.info("[리소스 릴리즈]");
//        }
//    }


    @Before("hello.aop.order.aop.Pointcuts.orderAndService()")
    public void doBefore(JoinPoint joinPoint) {
        log.info("[Before] {}", joinPoint.getSignature());
    }

    @AfterReturning(value = "hello.aop.order.aop.Pointcuts.orderAndService()", returning = "result")
    public void doReturn(JoinPoint joinPoint, Object result) {

        // signature, return값을 바꿀 수 없음.
        log.info("[return] {} return = {}", joinPoint.getSignature(), result);
    }

    @AfterReturning(value = "hello.aop.order.aop.Pointcuts.allOrder()", returning = "result")
    public void doReturnString(JoinPoint joinPoint, String result) {

        // signature, return값을 바꿀 수 없음.
        log.info("[return] {} return = {}", joinPoint.getSignature(), result);
    }



    // 자동으로 throwing 처리
    @AfterThrowing(value = "hello.aop.order.aop.Pointcuts.orderAndService()", throwing = "ex")
    public void doThrowing(JoinPoint joinPoint, Exception ex) {
        log.info("[ex] {} message = {}", ex);
    }

    @After(value = "hello.aop.order.aop.Pointcuts.orderAndService()")
    public void doAfter(JoinPoint joinPoint) {
        log.info("[after] {}", joinPoint.getSignature());
    }


}
