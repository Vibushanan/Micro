package com.example.demo;

import com.example.model.CService;
import com.example.model.coffeeService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.model") 
@ComponentScan(basePackages = { "com.example.end","com.example.model"} )
@EntityScan("com.example.model")
public class DemoApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	
	@Bean
	public coffeeService getHelloService(){
		return  new CService();
	}

	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		getHelloService().getALL();
	}
}
