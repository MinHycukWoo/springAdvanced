package hello.advanced.app.v3;

import hello.advanced.trace.TraceId;
import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.helloTraceV1.HelloTraceV2;
import hello.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV3 {

    private final LogTrace trace;

    public void save(String itemId){

        TraceStatus status = null;
        try{
            status = trace.begin("OrderRepositoryV1.save");

            //저장로직
            if(itemId.equals("ex")){
                throw new IllegalStateException("예외발생!");
            }
            sleep(1000);


            trace.end(status);
        }catch(Exception e){
            trace.exception(status ,e);
            throw e; //예외를 꼭 다시 던져줘야한다
            //흐름을 먹어버리지말고 그대로 반환한다.
        }


    }

    private void sleep(int millis){
        try{
            Thread.sleep(millis);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
