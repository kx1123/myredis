package com.study.redisstudy.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author jkx
 * @date 2021/11/27  16:39
 * @description
 */
@ConfigurationProperties(prefix = "redisson")
@Component
@Data
public class RedissonProperties {
    private String address;
}
