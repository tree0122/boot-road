package com.tree.bootroad.v001spring.atguigu.s011value.config;

import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.DefaultPropertySourceFactory;
import org.springframework.core.io.support.EncodedResource;

import java.io.IOException;
import java.util.List;

public class ConfigSourceFactory extends DefaultPropertySourceFactory {

    @Override
    public PropertySource<?> createPropertySource(String name, EncodedResource resource) throws IOException {
        if (resource == null){
            return super.createPropertySource(name, resource);
        }
        List<PropertySource<?>> load = new YamlPropertySourceLoader().load(resource.getResource().getFilename(), resource.getResource());
        return load.get(0);
    }
}
