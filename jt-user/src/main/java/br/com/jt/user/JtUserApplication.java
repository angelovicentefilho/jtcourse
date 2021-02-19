package br.com.jt.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EntityScan({ "br.com.jt.commons.entities" })
@EnableEurekaClient
@SpringBootApplication
public class JtUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(JtUserApplication.class, args);
	}

}
