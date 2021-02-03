package com.jiahao.per_demo.core.controller;

import com.jiahao.per_demo.common.json.JsonData;
import com.jiahao.per_demo.core.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class DemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping
    private JsonData findNum(){
        int num = demoService.findNum();
        return JsonData.ok(num);
    }
}
