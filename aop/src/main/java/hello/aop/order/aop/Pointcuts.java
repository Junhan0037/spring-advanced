package hello.aop.order.aop;

import org.aspectj.lang.annotation.Pointcut;

/**
 * 포인트컷을 공용으로 사용하기 위해 별도의 외부 클래스에 모아두어도 된다.
 */
public class Pointcuts {

    // hello.aop.order 패키지와 하위 패키지
    @Pointcut("execution(* hello.aop.order..*(..))")
    public void allOrder(){}

    // 클래스 이름 패턴이 *Service
    @Pointcut("execution(* *..*Service.*(..))")
    private void allService(){}

    // allOrder && allService
    @Pointcut("allOrder() && allService()")
    public void orderAndService() {}

}
