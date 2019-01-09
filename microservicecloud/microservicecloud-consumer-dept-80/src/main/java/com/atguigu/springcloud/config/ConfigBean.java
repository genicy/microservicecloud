package com.atguigu.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @introduction: microservicecloud
 * @Description: ${description}
 * @Author: yangxucheng
 * @Date: 2018/12/28 15:37
 * @Version: 1.0
 */
@Configuration
public class ConfigBean {
    /** 
    * @Description: RestTemplate提供了多种便捷访问远程Http服务的方法，
     * 是一种简单便捷的访问restful服务模板类，是Spring提供的用于访问Rest服务的客户端模板工具集 
    * @Param: [] 
    * @return: org.springframework.web.client.RestTemplate
    * @Author: yangxucheng 
    * @Date: 2018/12/28 16:01
    */ 
    @Bean
    @LoadBalanced //ribbon是基于客户端负载均衡的工具
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    /**
    * @Description:修改负载均衡算法，将默认轮询修改为随机
    * @Param: []
    * @return: com.netflix.loadbalancer.IRule
    * @Author: yangxucheng
    * @Date: 2019/1/4 16:30
    */
/*    @Bean
    public IRule iRule(){
        return new RandomRule();
    }*/
}
