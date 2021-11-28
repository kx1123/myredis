package com.study.redisstudy.redislock;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RReadWriteLock;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author jkx
 * @date 2021/11/27  16:07
 * @description
 */
@RestController
@RequestMapping("/redisLock")
public class RedisLock {

    @Resource
    Redisson redisson;

    @GetMapping("/redissonLock")
    public void redissonLock() {
        RLock lock = this.redisson.getLock("redisson");
        try {
            lock.lock();
        } finally {
            lock.unlock();
        }
    }

    @GetMapping("/readLock")
    public void readLock() {
        RReadWriteLock readWriteLock = this.redisson.getReadWriteLock("redisson");
        RLock lock = readWriteLock.readLock();
        try {
            lock.lock();
        } finally {
            lock.unlock();
        }
    }

    @GetMapping("/writeLock")
    public void writeLock() {
        RReadWriteLock readWriteLock = this.redisson.getReadWriteLock("redisson");
        RLock lock = readWriteLock.writeLock();
        try {
            lock.lock();
        } finally {
            lock.unlock();
        }
    }
}
