package com.example.restservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;
import redis.clients.jedis.*;

@RestController
public class HelloWorld {
    AtomicLong count = new AtomicLong(0);
    Jedis jedis = new Jedis("redis");



    @RequestMapping("/get")
    String hello() {
        return jedis.get("mykey");
    }
    @RequestMapping("/increment")
    void increment(){
        jedis.incr("mykey");
    }
}
