package com.jiahao.common.common.event;

import com.jiahao.common.core.entity.Demo;
import com.jiahao.common.core.service.impl.DemoServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @description: 监听器2
 * @author: jiahao
 * @date: 2021/2/4
 */
@Component
@Slf4j
public class DemoListener2 implements SmartApplicationListener {

    /**
     * 该方法返回true & supportsSourceType同样返回true时，才会调用该监听内的onApplicationEvent方法
     *
     * @param aClass: 接受事件监听类型
     * @author: jiahao
     * @date: 2021/1/21 18:24
     * @return: boolean
     */
    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> aClass) {
        //只有DemoEvent监听类型才会执行下面逻辑
        return aClass == DemoEvent.class;
    }

    /**
     * 该方法返回true&supportsEventType同样返回true时，才会调用该监听内的onApplicationEvent方法
     *
     * @param sourceType:
     * @author: jiahao
     * @date: 2021/1/21 18:28
     * @return: boolean
     */
    @Override
    public boolean supportsSourceType(Class<?> sourceType) {
        //只有DemoServiceImpl监听类型才会执行下面逻辑
        return sourceType == DemoServiceImpl.class;
    }

    /**
     * 同步情况下监听执行的顺序
     *
     * @author: jiahao
     * @date: 2021/1/21 18:31
     * @return: int
     */
    @Override
    public int getOrder() {
        return 3;
    }

    /**
     * supportsEventType & supportsSourceType 两个方法返回true时调用该方法执行业务逻辑
     *
     * @param applicationEvent:
     * @author: jiahao
     * @date: 2021/1/21 18:29
     * @return: void
     */
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        //转换事件类型
        DemoEvent event = (DemoEvent)applicationEvent;
        //获取注册用户对象信息
        Demo demo = event.getDemo();
        log.info("smart事件监听2：{}", demo);
    }
}
