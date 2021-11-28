package com.study.redisstudy.config;

import org.redisson.Redisson;
import org.redisson.client.RedisClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jkx
 * @date 2021/11/27  16:23
 * @description
 */
@Configuration
public class RedissonConfig {

    @Autowired
    private RedissonProperties redissonProperties;

    @Bean
    public Redisson redisson(){
        Config config = new Config();
        config.useSingleServer().setAddress(redissonProperties.getAddress()).setDatabase(0);
        return (Redisson) Redisson.create(config);
    }
}
