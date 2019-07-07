package com.tree.autoconfigure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "example.service")
public class ExampleServiceProperties {
    private String prefix;
    private String suffix;
}
