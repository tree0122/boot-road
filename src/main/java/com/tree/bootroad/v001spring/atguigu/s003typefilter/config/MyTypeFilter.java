package com.tree.bootroad.v001spring.atguigu.s003typefilter.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * 自定义的扫描规则
 */
@Slf4j
public class MyTypeFilter implements TypeFilter {
    /**
     *
     * @param metadataReader: 当前正在扫描的类的信息
     * @param metadataReaderFactory: 可以获取到其他任何类的信息
     * @return
     * @throws IOException
     */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        AnnotationMetadata annotation = metadataReader.getAnnotationMetadata();
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        log.info("annotation: {}", annotation.getAnnotationTypes());
        log.info("classMetadata: {}", classMetadata.getClassName());
        if (classMetadata.getClassName().contains("Person")){
            return true;
        }
        return false;
    }
}
