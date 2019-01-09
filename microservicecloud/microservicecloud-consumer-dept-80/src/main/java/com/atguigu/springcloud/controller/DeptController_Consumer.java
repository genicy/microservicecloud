package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.config.ConfigBean;
import com.atguigu.springcloud.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.security.auth.login.Configuration;
import java.util.List;

/**
 * @introduction: microservicecloud
 * @Description: ${description}
 * @Author: yangxucheng
 * @Date: 2018/12/28 15:38
 * @Version: 1.0
 */
@RestController
public class DeptController_Consumer {
    private static final String REST_URL_PREFIX="http://microservicecloud-dept";
    @Autowired
    private RestTemplate restTemplate;
    /**
    * @Description:
     * 使用 使用restTemplate访问restful接口非常的简单 (url, requestMap,
     * ResponseBean.class)这三个参数分别代表 REST请求地址、请求参数、相应参数。
    * @Param: [dept]
    * @return: boolean
    * @Author: yangxucheng
    * @Date: 2018/12/28 16:02
    */
    @RequestMapping(value = "/consumer/dept/add")
    public boolean add(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add",dept,Boolean.class);
    }

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id,Dept.class);
    }
    @RequestMapping("/consumer/dept/list")
    public List<Dept> list(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list",List.class);
    }
}
