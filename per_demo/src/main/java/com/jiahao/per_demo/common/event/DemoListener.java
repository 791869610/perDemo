package com.jiahao.per_demo.common.event;

import com.jiahao.per_demo.core.entity.Demo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
* @description: 监听器2
* @author: jiahao
* @date: 2021/2/4
*/
@Component
@Slf4j
public class DemoListener {

    /**
     * 使用注解{@Async}异步监听事件，不影响主业务
     * @author: jiahao
     * @date: 2021/2/4 19:16
     * @param demoEvent:
     * @return: void
     */
    @EventListener
    @Async
    public void listener(DemoEvent demoEvent) {
        Demo demo = demoEvent.getDemo();
        log.info("@EventListener事件监听1：{}", demo);
    }
}
