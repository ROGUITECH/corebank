package com.rogui.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class RoguiEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoguiEurekaServerApplication.class, args);
	}

}
