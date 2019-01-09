package com.atguigu.springcloud.controller;

import java.util.List;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptService;

@RestController
public class DeptController
{
	@Autowired
	private DeptService deptService=null;

	private Logger logger = LoggerFactory.getLogger(getClass());

	@PostMapping(value = "/dept/add")
	public boolean add(@RequestBody Dept dept)
	{
		return deptService.add(dept);
	}


	@GetMapping(value = "/dept/get/{id}")
	@HystrixCommand(fallbackMethod = "processHystrix_GET")
	public Dept get(@PathVariable("id") Long id){
		Dept dept = deptService.get(id);

		if(dept==null){
			logger.info("lalala");
			throw  new RuntimeException("该id:"+ id + "没有对应的消息");
		}
		return dept;
	}

	public Dept processHystrix_GET(@PathVariable("id") Long id){
		Dept dept = new Dept(id,"暂无该信息","not in database");
		return dept;
	}

	@RequestMapping(value = "/dept/list", method = RequestMethod.GET)
	public List<Dept> list()
	{
		return deptService.list();
	}


}
