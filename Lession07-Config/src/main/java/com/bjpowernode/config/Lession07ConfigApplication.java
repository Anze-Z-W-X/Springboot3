package com.bjpowernode.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan(basePackages = {"com.bjpowernode.config.pk8"})
public class Lession07ConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lession07ConfigApplication.class, args);
	}

}
