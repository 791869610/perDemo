package com.jiahao.per_demo.common.event;

import com.jiahao.per_demo.core.entity.Demo;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
* @description: demo event
* @author: jiahao
* @date: 2021/2/4
*/
@Getter
public class DemoEvent extends ApplicationEvent {

    private Demo demo;

    /**
     * 重写构造方法
     * @author: jiahao
     * @date: 2021/1/21 17:24
     * @param source:
     * @param demo:
     * @return: null
     */
    public DemoEvent(Object source,Demo demo) {
        super(source);
        this.demo = demo;
    }
}
