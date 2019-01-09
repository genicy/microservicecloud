package com.atguigu.springcloud.controller;

import java.util.List;

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
	private DeptService deptService;

	@PostMapping(value = "/dept/add")
	public boolean add(@RequestBody Dept dept)
	{
		return deptService.add(dept);
	}


	@GetMapping(value = "/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id){
		return deptService.get(id);
	}

	@RequestMapping(value = "/dept/list", method = RequestMethod.GET)
	public List<Dept> list()
	{
		return deptService.list();
	}


}
