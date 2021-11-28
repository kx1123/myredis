package com.study.redisstudy.baseoperate;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author jkx
 * @date 2021/10/31  22:09
 * @description
 */
@Slf4j
@RestController
@RequestMapping("/redisBaseOperate")
public class RedisBaseOperate {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/testTemplate")
    public void testTemplate() {
        stringRedisTemplate.opsForValue().set("testTemplate", "11");
    }


    public static void main(String[] args) {

        Jedis jedis = new Jedis("localhost");
        testString(jedis);
//        testHash(jedis);
//        testList(jedis);
//        testSet(jedis);
    }

    public static void testString(Jedis jedis) {
        jedis.set("test", "111");
        jedis.mset("addr","sz", "name","张三");
        List<String> list = jedis.mget("addr", "name", "test");
        list.forEach(t-> log.info("========{},",t));
        // 层级存储
        jedis.set("string:a01", "01");
        jedis.set("a:b:c", "02");
        log.info("========={}", jedis.get("a:b"));
    }



    public static void testHash(Jedis jedis) {
        jedis.hset("hash", "name", "张三");
        log.info("==========={}", jedis.hget("hash", "name"));
        Map<String, String> map = new HashMap<>();
        map.put("age", "20");
        map.put("money", "1");
        jedis.hmset("hash", map);
        Map<String, String> m = jedis.hgetAll("hash");
        m.entrySet().forEach(t -> log.info("{}==={}", t.getKey(), t.getValue()));
        log.info("{}", jedis.hget("hash", "money"));
    }

    public static void testList(Jedis jedis) {
        jedis.lpush("num", "1", "#");
        jedis.rpush("num", "r1");
        List<String> num = jedis.lrange("num", 0, 2);
        num.forEach(t -> log.info("===={}", t));
        log.info("==={}", jedis.llen("num"));
    }

    public static void testSet(Jedis jedis) {
        jedis.sadd("set", "a", "B", "c");

        Set<String> set = jedis.smembers("set");
        set.forEach(t -> log.info("===={}", t));
        jedis.srem("set", "c");
        jedis.del("set");
    }




}
