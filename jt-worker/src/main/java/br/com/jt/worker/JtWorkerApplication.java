package br.com.jt.worker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EntityScan({ "br.com.jt.commons.entities" })
@EnableEurekaClient
@SpringBootApplication
public class JtWorkerApplication {

	public static void main(String[] args) {
		SpringApplication.run(JtWorkerApplication.class, args);
	}

}
