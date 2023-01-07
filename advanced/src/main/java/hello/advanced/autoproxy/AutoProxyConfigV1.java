package hello.advanced.autoproxy;

import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AutoProxyConfigV1 {

    @Bean
    public Advisor advisorV2(LogTraceV1 logTraceV1) {

        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(
                "execution(* hello.advanced.autoproxy..*(..)) " +
                        "&& !execution(* hello.advanced.autoproxy..join(..))"
        ); //autoproxy 하위 모든 패키지, 파라미터 모두 적용
        LogTraceV1Advice advice = new LogTraceV1Advice(logTraceV1);
        return new DefaultPointcutAdvisor(pointcut, advice);
    }

}


//    //    @Bean
//    public Advisor advisorV1(LogTraceV1 logTraceV1) {
//
//        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
//        pointcut.setMappedNames("joinTeam*", "join*");
//
//        LogTraceV1Advice advice = new LogTraceV1Advice(logTraceV1);
//        return new DefaultPointcutAdvisor(pointcut, advice);
//    }