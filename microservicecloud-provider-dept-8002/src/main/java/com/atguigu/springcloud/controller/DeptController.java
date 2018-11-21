package com.atguigu.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.springcloud.service.DeptService;
import com.atguigu.springcloud.entities.Dept;

@RestController
public class DeptController {

	@Autowired
	private DeptService service;
	
	@Autowired
	private DiscoveryClient client;
	
	@PostMapping("/dept/add")
	public boolean add(@RequestBody Dept dept){
		
		return service.addDept(dept);
	}
	
	
	@GetMapping("/dept/get/{id}")
	public Dept get(@PathVariable Long id){
		return service.get(id);
	}
	
	@GetMapping("/dept/list")
	public List<Dept> list() {
		return service.list();
	}
	
	@GetMapping("/dept/discovery")
	public Object discovery(){
		List<String> list = client.getServices();
		System.out.println("************" + list);

		List<ServiceInstance> sevList = client.getInstances("MICROSERVICECLOUD-DEPT");
		for (ServiceInstance element : sevList) {
			System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() +
					"\t" + element.getUri());
		}
		
		return this.client;
	}
}
