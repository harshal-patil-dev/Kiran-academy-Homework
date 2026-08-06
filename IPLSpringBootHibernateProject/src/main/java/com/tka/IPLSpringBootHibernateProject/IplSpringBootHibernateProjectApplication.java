package com.tka.IPLSpringBootHibernateProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.tka")
@EntityScan(basePackages =  "com.tka.entity")
public class IplSpringBootHibernateProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(IplSpringBootHibernateProjectApplication.class, args);
		System.out.println("Application running...");
	}

}
