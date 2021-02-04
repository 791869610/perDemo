package com.jiahao.common.core.mapper;

import com.jiahao.common.config.mapper.MyBaseMapper;
import com.jiahao.common.core.entity.Demo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface DemoMapper extends MyBaseMapper<Demo> {

    int selectNum();
}
