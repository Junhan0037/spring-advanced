package hello.proxy.common.advice;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

@Slf4j
public class TimeAdvice implements MethodInterceptor {

    /**
     * 내부에는 다음 메서드를 호출하는 방법, 현재 프록시 객체 인스턴스, args, 메서드 정보 등이 포함되어 있다.
     * 기존에 파라미터로 제공되는 부분들이 이 안으로 모두 들어갔다고 생각하면 된다.
     * org.aopalliance.intercept 패키지는 스프링 AOP 모듈(spring-top) 안에 들어있다.
     * MethodInterceptor 는 Interceptor 를 상속하고, Interceptor 는 Advice 인터페이스를 상속한다.
     */
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        log.info("TimeProxy 실행");
        long startTime = System.currentTimeMillis();

        // target 클래스를 호출하고 그 결과를 받는다.
        // target 클래스의 정보는 MethodInvocation invocation 안에 모두 포함되어 있다.
        // 프록시 팩토리를 생성하는 단계에서 이미 target 정보를 파라미터로 전달받기 때문이다.
        Object result = invocation.proceed();

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("TimeProxy 종료 resultTime={}ms", resultTime);

        return result;
    }

}
