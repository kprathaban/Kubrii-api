package com.businesslisting.kubrii.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan(basePackages = "com.businesslisting.kubrii")
@EntityScan("com.businesslisting.kubrii.entity")
@EnableJpaRepositories("com.businesslisting.kubrii.repository")
public class KubriiApiApplication {

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(KubriiApiApplication.class, args);
		System.out.println("This is the first web servive of Kubrii Business Listing Project ");
	}

}
