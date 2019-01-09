package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.config.ConfigBean;
import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptClientService;
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
    @Autowired
    private DeptClientService service;
    @RequestMapping(value = "/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id)
    {
        return this.service.get(id);
    }

    @RequestMapping(value = "/consumer/dept/list")
    public List<Dept> list()
    {
        return this.service.list();
    }

    @RequestMapping(value = "/consumer/dept/add")
    public Object add(Dept dept)
    {
        return this.service.add(dept);
    }

}
