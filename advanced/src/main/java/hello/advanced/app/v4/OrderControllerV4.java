package hello.advanced.app.v4;

import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV4 {

    private final OrderServiceV4 orderService;
    private final LogTrace trace;

    @GetMapping("/v4/request")
    public String request(String itemId) {
        AbstractTemplate<String> template = new AbstractTemplate<>(trace) { // 제네릭을 String 으로 설정 => 반환 타입은 String
            @Override
            protected String call() { // 익명 내부 클래스
                orderService.orderItem(itemId);
                return "ok";
            }
        };
        return template.execute("OrderController.request()"); // 템플릿을 실행하면서 로그로 남길 message 전달
    }

}
