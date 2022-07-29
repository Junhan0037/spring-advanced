package hello.proxy.jdkdynamic.code;

import java.lang.reflect.Method;
import lombok.extern.slf4j.Slf4j;

/**
 * JDK 동적 프록시에서 적용할 공통 로직
 */
@Slf4j
public class TimeInvocationHandler implements InvocationHandler {

    private final Object target;

    public TimeInvocationHandler(Object target) { // 동적 프록시가 호출할 대상
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("TimeProxy 실행");
        long startTime = System.currentTimeMillis();

        // 리플렉션을 사용해서 target 인스턴스의 메서드를 실행
        // args 는 메서드 호출시 넘겨질 인수
        Object result = method.invoke(target, args);

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("TimeProxy 종료 resultTime={}", resultTime);

        return result;
    }

}
