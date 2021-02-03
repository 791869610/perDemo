package com.jiahao.per_demo.core.service.impl;

import com.jiahao.per_demo.core.mapper.DemoMapper;
import com.jiahao.per_demo.core.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    private DemoMapper demoMapper;

    @Override
    public int findNum() {
        return demoMapper.selectNum();
    }

}
