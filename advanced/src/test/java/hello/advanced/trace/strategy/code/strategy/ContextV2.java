package hello.advanced.trace.strategy.code.strategy;

import lombok.extern.slf4j.Slf4j;

/**
* 전략을 파라미터로 전달 받는 방식
* */
@Slf4j
public class ContextV2 {
    /*
    private Strategy strategy;

    public ContextV2(Strategy strategy){
        this.strategy = strategy;
    }
    */

    public void execute(Strategy strategy){
        long startTime = System.currentTimeMillis();
        //비즈니스 로직 실행
        strategy.call();
        //비즈리스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}" , resultTime);
    }
}
