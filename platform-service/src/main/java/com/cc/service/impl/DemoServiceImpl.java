package com.cc.service.impl;

import com.cc.mapper.DemoMapper;
import com.cc.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Chengcheng on 2017/5/24.
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private DemoMapper demoMapper;

    @Override
    public int getCount() {
        Integer count = demoMapper.getCount();
        return count == null?0:count;
    }
}
