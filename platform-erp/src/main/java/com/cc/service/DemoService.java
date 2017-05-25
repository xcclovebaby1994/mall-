package com.cc.service;

import com.cc.mapper.DemoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Chengcheng on 2017/5/24.
 */
@Service
public class DemoService {

    @Autowired
    private DemoMapper demoMapper;

    public int getCount() {
        Integer count = demoMapper.getCount();
        return count == null?0:count;
    }
}
