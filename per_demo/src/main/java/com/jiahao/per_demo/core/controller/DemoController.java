package com.jiahao.per_demo.core.controller;

import com.jiahao.per_demo.common.json.JsonData;
import com.jiahao.per_demo.core.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@Slf4j
public class DemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping
    public JsonData findNum(){
        log.info("this is test");
        int num = demoService.findNum();
        return JsonData.ok(num);
    }
}
