package hello.proxy.jdkdynamic.code;

import java.lang.reflect.Method;

public interface InvocationHandler {
    // 프록시 자신, 호출한 메서드, 메서드를 호출할 때 전달한 인수
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
