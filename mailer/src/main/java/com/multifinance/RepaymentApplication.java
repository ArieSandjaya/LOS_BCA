package com.multifinance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableEurekaClient
@SpringBootApplication
@EnableJpaAuditing
@EnableScheduling
public class RepaymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(RepaymentApplication.class, args);
	}

}
