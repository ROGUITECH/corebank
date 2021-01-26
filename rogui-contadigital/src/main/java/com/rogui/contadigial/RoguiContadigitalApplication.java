package com.rogui.contadigial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class RoguiContadigitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoguiContadigitalApplication.class, args);
	}

}
