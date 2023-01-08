package hello.aop.order.aop.member.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodAop {
    // retentionPolicy  -> source 컴파일 시점에 날라간다.
    // runtime으로 설정해야 실행 시점에 동적으로 처리 가능
    String value();
}
