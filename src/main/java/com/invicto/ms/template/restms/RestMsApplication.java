package com.invicto.ms.template.restms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(value = " com.invicto.ms.template.restms.repo")
@EntityScan(" com.invicto.ms.template.restms.entity")
public class RestMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestMsApplication.class, args);
	}

}
