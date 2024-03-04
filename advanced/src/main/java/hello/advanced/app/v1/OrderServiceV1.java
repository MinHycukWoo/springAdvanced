package hello.advanced.app.v1;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.helloTraceV1.HelloTraceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV1 {

    private final OrderRepositoryV1 orderRepository;
    private final HelloTraceV1 trace;

    public void orderItem(String itemId){


        TraceStatus status = null;
        try{
            status = trace.begin("OrderServiceV1.orderItem");
            orderRepository.save(itemId);
            trace.end(status);
        }catch(Exception e){
            trace.exception(status ,e);
            throw e; //예외를 꼭 다시 던져줘야한다
            //흐름을 먹어버리지말고 그대로 반환한다.
        }



    }

}