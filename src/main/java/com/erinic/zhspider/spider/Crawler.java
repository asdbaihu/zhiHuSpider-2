package com.erinic.zhspider.spider;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by Administrator on 2017/3/31 0031.
 */
public interface Crawler {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:/config/spring-*.xml");
    JedisPool pool = new JedisPool(new JedisPoolConfig(), "127.0.0.1",6379,2000,"code=redis?");
    public void crawl();
}
