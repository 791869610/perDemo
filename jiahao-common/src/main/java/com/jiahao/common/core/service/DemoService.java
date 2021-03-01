package com.jiahao.common.core.service;

import com.jiahao.common.core.entity.Demo;

/**
* @description:  DemoService
* @author: jiahao
* @date: 2021/2/4
*/
public interface DemoService {

    void modify(Demo demo);
    /**
     * findNum
     * @author: jiahao
     * @date: 2021/2/4 19:08
     * @return: int
     */
    int findNum();

    /**
     * event事件监听测试接口
     * @author: jiahao
     * @date: 2021/2/4 19:08
     * @return: void
     */
    void eventTest();
}
