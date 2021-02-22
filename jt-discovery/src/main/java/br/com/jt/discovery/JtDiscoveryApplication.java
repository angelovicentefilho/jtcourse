package br.com.jt.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class JtDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(JtDiscoveryApplication.class, args);
	}

}
