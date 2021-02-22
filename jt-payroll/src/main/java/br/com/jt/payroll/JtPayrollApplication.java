package br.com.jt.payroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableCircuitBreaker
@EnableEurekaClient
@EnableFeignClients
@EntityScan({ "br.com.jt.commons.entities" })
@SpringBootApplication
public class JtPayrollApplication {

	public static void main(String[] args) {
		SpringApplication.run(JtPayrollApplication.class, args);
	}

}
