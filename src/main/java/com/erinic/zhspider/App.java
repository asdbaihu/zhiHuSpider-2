package com.erinic.zhspider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Administrator on 2017/3/24 0024.
 */
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(new String[]{
                "classpath*:/config/spring-*.xml",
        }, args);
    }
}
