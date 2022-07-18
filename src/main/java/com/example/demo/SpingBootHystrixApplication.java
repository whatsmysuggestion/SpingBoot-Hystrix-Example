package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@SpringBootApplication
@EnableHystrix
@RestController
public class SpingBootHystrixApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpingBootHystrixApplication.class, args);
	}
	
	
	@RequestMapping(value="/hello")
	@HystrixCommand(fallbackMethod="sayhellofallback", commandProperties= {@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="1000")})
	public  String sayhello(){
		
		try
		{
			
			Thread.sleep(2000);
		}
		catch(Exception e)
		{
			
		}
		
		return "Hello From Main Method";
	}
	
	
	public  String sayhellofallback()
	{
		return "Hello From Fallback Method";
	}
	
	

}
