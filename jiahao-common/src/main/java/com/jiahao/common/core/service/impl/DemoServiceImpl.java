package com.jiahao.common.core.service.impl;

import java.util.Date;

import com.jiahao.common.common.event.DemoEvent;
import com.jiahao.common.core.entity.Demo;
import com.jiahao.common.core.mapper.DemoMapper;
import com.jiahao.common.core.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * @description: DemoServiceImpl
 * @author: jiahao
 * @date: 2021/2/4
 */
@Service
@Slf4j
public class DemoServiceImpl implements DemoService {

    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private DemoMapper demoMapper;

    /**
     * @description: findNum
     * @author: jiahao
     * @date: 2021/2/4
     */
    @Override
    public int findNum() {
        return demoMapper.selectNum();
    }

    /**
     * event事件监听测试接口
     *
     * @author: jiahao
     * @date: 2021/2/4 19:08
     * @return: void
     */
    @Override
    public void eventTest() {
        log.info("发布事件start=========");
        Demo demo = Demo.builder().id(1).name("event测试").createDate(new Date()).build();
        applicationContext.publishEvent(new DemoEvent(this, demo));
        log.info("发布事件end=========");
    }

}
