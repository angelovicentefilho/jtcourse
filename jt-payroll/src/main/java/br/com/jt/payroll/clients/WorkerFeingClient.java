package br.com.jt.payroll.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.jt.commons.protocols.worker.WorkerResponse;

@Service
@FeignClient(name = "JTWORKER-SERVICE", path = "/workers")
public interface WorkerFeingClient {

	@GetMapping("/{id}")
	WorkerResponse findById(@PathVariable Long id);
	
	@GetMapping
	WorkerResponse findAll();
	
}
