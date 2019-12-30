package com.example.restservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import redis.clients.jedis.*;
@SpringBootApplication
public class RestserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestserviceApplication.class, args);
		Jedis jedis = new Jedis("redis");
		jedis.del("mykey");
		jedis.set("mykey","0");
	}

}
