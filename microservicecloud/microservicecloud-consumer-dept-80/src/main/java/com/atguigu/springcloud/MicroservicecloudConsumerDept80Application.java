package com.atguigu.springcloud;

import com.atguigu.myrule.MyselfRule;
import org.apache.catalina.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import java.util.ArrayList;
import java.util.LinkedList;

@SpringBootApplication
//可在主启动类上加入注解添加自定义负载均衡算法
@RibbonClient(name = "microservicecloud-dept" ,configuration = MyselfRule.class)
@EnableEurekaClient
public class MicroservicecloudConsumerDept80Application {

    public static void main(String[] args) {
        SpringApplication.run(MicroservicecloudConsumerDept80Application.class, args);
    }

}

