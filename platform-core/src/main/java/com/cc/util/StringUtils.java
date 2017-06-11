package com.cc.util;

import java.util.UUID;

/**
 * Created by Chengcheng on 2017/6/11.
 */
public abstract class StringUtils {

    /**
     * 生成uuid
     * @return
     */
    public static String uuid(){
        String uuid = UUID.randomUUID().toString();
        String[] splits = uuid.split("-");
        StringBuilder builder = new StringBuilder();
        for (String split: splits){
            builder.append(split);
        }
        return builder.toString();
    }
}
