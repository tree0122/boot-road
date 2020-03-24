package com.tree.bootroad.v001spring.atguigu.s003typefilter.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

@Slf4j
public class MyTypeFilter implements TypeFilter {
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
