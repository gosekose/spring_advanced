package hello.aop.order.member.pointcuttest;

import hello.aop.order.aop.member.MemberService;
import hello.aop.order.aop.member.MemberServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;

import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class ExecutionTest {

    AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
    Method helloMethod;

    @BeforeEach
    public void init() throws NoSuchMethodException {
        // 리플랙션으로 메소드 정보를 빼옴, hello에 파라미터 타입이 String 이므로
        helloMethod = MemberServiceImpl.class.getMethod("hello", String.class);
    }

    @Test
    public void printMethod() throws Exception {
        //given
        // public java.lang.String hello.aop.order.aop.member.MemberServiceImpl.hello(java.lang.String)
        log.info("helloMethod = {}", helloMethod);
        //when


        //then

    }

    @Test
    void exactMatch() {
        pointcut.setExpression("execution(public String hello.aop.order.aop.member.MemberServiceImpl.hello(java.lang.String))");
        assertThat(pointcut.matches(helloMethod, MemberServiceImpl.class)).isTrue();
    }

    @Test
    void allMatch() {
        // 접근 제어자 생략
        // 반환 타입 '*'
        // 선언 타입 생략
        // 메서드 이름 *
        // 파라미터 (..)
        // 예외? 없음
        pointcut.setExpression("execution(* *(..))");
        assertThat(pointcut.matches(helloMethod, MemberServiceImpl.class)).isTrue();
    }

    @Test
    // 메서드 이름 동일
    void namePatternMatch1() {
        pointcut.setExpression("execution(* hel*(..))");
        assertThat(pointcut.matches(helloMethod, MemberServiceImpl.class)).isTrue();
    }

    @Test
    void namePatternMatcher2() {
        pointcut.setExpression("execution(* *el*(..))");
        assertThat(pointcut.matches(helloMethod, MemberServiceImpl.class)).isTrue();
    }

    @Test
    void namePatternMatcher3() {
        pointcut.setExpression("execution(* none(..))");
        assertThat(pointcut.matches(helloMethod, MemberServiceImpl.class)).isFalse();
    }

    @Test
    void packageExactMatch1() {
        pointcut.setExpression("execution(* hello.aop.order.aop.member.MemberServiceImpl.hello(..))");
        assertThat(pointcut.matches(helloMethod, MemberServiceImpl.class)).isTrue();
    }


    @Test
    void packageExactMatch2() {
        pointcut.setExpression("execution(* hello.aop.order.aop.member.*.*(..))");
        assertThat(pointcut.matches(helloMethod, MemberServiceImpl.class)).isTrue();
    }


    @Test
    void packageExactMatch3() {
        // hello aop의 패키지에 맞아야 함. MemberServiceImpl은 hello.aop.member 패키지이므로 정확하게 맞지 않아서 에러가 발생한다.
        pointcut.setExpression("execution(* hello.aop.*.*.*(..))");
        assertThat(pointcut.matches(helloMethod, MemberServiceImpl.class)).isFalse();
    }

    @Test
    void packageSubPackage1() {
        // hello aop의 하위 패키지까지 포함하기 위해서는 ..이 들어 가야함
        pointcut.setExpression("execution(* hello.aop..*.*(..))");
        assertThat(pointcut.matches(helloMethod, MemberServiceImpl.class)).isTrue();
    }
    //. 정확하게 해당 위치
    //.. 하위 패키지 포함

    @Test
    void typeExactMatch() {
        pointcut.setExpression("execution(* hello.aop.order.aop.member.MemberServiceImpl.*(..))");
        assertThat(pointcut.matches(helloMethod, MemberServiceImpl.class)).isTrue();
    }

    @Test
    void typeExactSuperTypeMatch() {
        // 부모타입으로 매칭이 된다 !!! 타입 매칭 (다형성)
        pointcut.setExpression("execution(* hello.aop.order.aop.member.MemberService.*(..))");
        assertThat(pointcut.matches(helloMethod, MemberService.class)).isTrue();
    }



}
