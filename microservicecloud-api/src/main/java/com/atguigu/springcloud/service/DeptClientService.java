package com.atguigu.springcloud.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.atguigu.springcloud.entities.Dept;

//@FeignClient(value="MICROSERVICECLOUD-DEPT")
@FeignClient(value="MICROSERVICECLOUD-DEPT",fallbackFactory=DeptClientServiceFallbackFactory.class)
public interface DeptClientService {

	@PostMapping("/dept/add")
	public boolean addDept(Dept dept);

	@GetMapping("/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id);

	@GetMapping("/dept/list")
	public List<Dept> list();
}
