package com.teambpm.restapi.sample.hateaos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.teambpm.restapi.sample.hateoas.resource.UsersResource;

@SpringBootApplication
@ComponentScan(basePackageClasses=UsersResource.class)

public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}