package com.jiahao.common.core.controller;

import java.util.Date;

import com.jiahao.common.common.json.JsonData;
import com.jiahao.common.core.entity.Demo;
import com.jiahao.common.core.service.DemoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* @description:  DemoController
* @author: jiahao
* @date: 2021/2/4
*/
@RestController
@RequestMapping
@Slf4j
@Api(value = "DemoController")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping("/modify")
    @ApiOperation("测试update mapper")
    public JsonData modify(){
        Demo demo = Demo.builder()
            .id(1)
            //.name("test")
            //.createDate(new Date())
            .build();
        this.demoService.modify(demo);
        return JsonData.ok();
    }

    /**
     * findNum controller
     * @author: jiahao
     * @date: 2021/2/4 19:13
     * @return: com.jiahao.per_demo.common.json.JsonData
     */
    @GetMapping
    @ApiOperation("获取数量")
    public JsonData findNum(){
        log.info("this is test");
        int num = demoService.findNum();
        return JsonData.ok(num);
    }

    /**
     * event test
     * @author: jiahao
     * @date: 2021/2/4 19:14
     * @return: com.jiahao.per_demo.common.json.JsonData
     */
    @GetMapping("/event")
    public JsonData eventTest(){
        log.info("this is event test");
        demoService.eventTest();
        return JsonData.ok();
    }
}
