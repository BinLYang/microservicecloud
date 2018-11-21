package com.atguigu.springcloud.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@Configuration
public class ConfigBean {//boot -->spring applicationContext.xml --@Configuration配置 ConfigBean = applicationContext.xml 

	@Bean
	@LoadBalanced  //Sping Cloud Ribbon是基于NetFlix Ribbon实现的一套客户端	负载均衡工具
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
	
	//显示声明  均衡算法
	@Bean
	public IRule myRule(){
		return new RandomRule();
	}
}
