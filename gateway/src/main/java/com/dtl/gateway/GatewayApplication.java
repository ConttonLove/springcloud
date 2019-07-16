package com.dtl.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 二代路由网关 gateway
 * @author LBZ
 */
@SpringBootApplication
@RestController
@EnableEurekaClient
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    /**
     * 默认降级处理
     */
    @RequestMapping(value = "/defaultFallback")
    public Map<String,String> defaultFallback(){
        System.out.println("降级操作...");
        Map<String,String> map = new HashMap<>();
        map.put("resultCode","fail");
        map.put("resultMessage","服务连接超时");
        map.put("resultObj","null");
        return map;
    }

}
