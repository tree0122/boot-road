package com.tree.bootroad.x010web.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "com.tree")
public class TreeProperties {
    private String title;
    private String desc;
}
