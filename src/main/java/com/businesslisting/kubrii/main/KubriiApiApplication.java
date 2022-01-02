package com.businesslisting.kubrii.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.businesslisting.kubrii" )
@EntityScan("com.businesslisting.kubrii.entity")
@EnableJpaRepositories("com.businesslisting.kubrii.repository")
public class KubriiApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(KubriiApiApplication.class, args);
		System.out.println("This is the Business Listing Project ");
	}

}
