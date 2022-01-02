package com.businesslisting.kubrii.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.businesslisting.kubrii" )
@EntityScan("com.businesslisting.kubrii.entity")
@EnableJpaRepositories("com.businesslisting.kubrii.repository")
public class KubriiApiApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(KubriiApiApplication.class, args);
		System.out.println("This is a first weservive of the Kubrii Business Listing Project ");
	}

}
