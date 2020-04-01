package com.tree.bootroad.v002springmvc.atguigu.m03converter;

import org.springframework.core.convert.converter.Converter;

public class CustomConvert implements Converter<String, Job> {

    @Override
    public Job convert(String source) {
        return null;
    }
}
