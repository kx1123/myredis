package com.study.redisstudy.baseoperate;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;

/**
 * @author jkx
 * @date 2021/10/31  22:09
 * @description
 */
@Slf4j
public class RedisBaseOperate {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        jedis.set("test", "111");
        log.info("======{}", jedis.get("test"));
    }
}
