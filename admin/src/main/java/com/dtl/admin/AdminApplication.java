package com.dtl.admin;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Turing后台管理系统
 *
 * 注解@EnableEurekaClient => 注册服务
 * 注解@EnableHystrix => 开启断路器
 * 注解@EnableHystrixDashboard => 开启Hystrix仪表盘
 * @author LBZ
 */
@SpringBootApplication
@RestController
@EnableEurekaClient
@EnableHystrix
@EnableHystrixDashboard
public class AdminApplication {


    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }

//    @Value("${server.port}")
//    String port;


    /**
     * http://localhost:10100/hi
     */
    @RequestMapping("/hi")
    @HystrixCommand(fallbackMethod = "hiError")
    public String home(@RequestParam(value = "name", defaultValue = "forezp") String name) {
//        return "hi " + name + " ,i am from port:" + port;
        return "hi " + name + " ,i am from port:9696";
    }

    public String hiError(String name) {
        return "hi,"+name+",sorry,error!";
    }


    /**
     * http://localhost:10100/timeout
     */
    @RequestMapping("/timeout")
    public String timeout(){
        try{
            //睡5秒，网关Hystrix3秒超时，会触发熔断降级操作
            Thread.sleep(11000);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "timeout";
    }

    /**
     * http://localhost:10100/hello
     */
    @RequestMapping("/hello")
    public String hello(String name){
        return "hi " + name;
    }

}
