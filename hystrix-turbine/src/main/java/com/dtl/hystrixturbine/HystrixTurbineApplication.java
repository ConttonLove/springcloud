package com.dtl.hystrixturbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.web.bind.annotation.RestController;

/**
 * 断路器聚合监控
 * Turbine是聚合服务器发送事件流数据的一个工具，Hystrix的监控中，只能监控单个节点，实际生产中都为集群，因此可以通过Turbine来监控集群下Hystrix的metrics情况
 *
 * 注解@EnableEurekaClient => 注册服务
 * 注解@EnableHystrix => 开启断路器
 * 注解@EnableHystrixDashboard => 开启Hystrix仪表盘
 * 注解@EnableTurbine => 开启断路器聚合监控
 * @author LBZ
 */
@SpringBootApplication
@RestController
@EnableEurekaClient
@EnableHystrix
@EnableHystrixDashboard
@EnableTurbine
public class HystrixTurbineApplication {

    /**
     * http://localhost:10020/turbine.stream
     * 放入
     * http://localhost:10020/hystrix
     * 中
     */
    public static void main(String[] args) {
        SpringApplication.run(HystrixTurbineApplication.class, args);
    }

}
