package com.dtl.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * EurekaServer服务器端启动类
 * <p>
 * 注解@EnableEurekaServer => EurekaServer服务器端启动类，接受其他微服务注册进来
 *
 * @author LBZ
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {

    /**
     * http://localhost:9999/
     */
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class, args);
    }

}
