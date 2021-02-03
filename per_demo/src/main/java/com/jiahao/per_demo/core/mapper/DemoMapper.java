package com.jiahao.per_demo.core.mapper;

import com.jiahao.per_demo.config.mapper.MyBaseMapper;
import com.jiahao.per_demo.core.entity.Demo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface DemoMapper extends MyBaseMapper<Demo> {

    int selectNum();
}
