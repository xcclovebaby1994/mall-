package com.cc.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Created by Chengcheng on 2017/5/24.
 */
@Mapper
public interface DemoMapper {

    Integer getCount();
}
