package br.com.jt.worker.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jt.commons.protocols.worker.WorkerResponse;
import br.com.jt.worker.services.WorkerService;

@RefreshScope
@RestController
@CrossOrigin
public class WorkerResource {

	private final WorkerService workerService;
	
	@Autowired
	public WorkerResource(WorkerService service) {
		this.workerService = service;
	}
	
	@GetMapping
	public WorkerResponse findAll() {
		return this.workerService.findAll();
	}
	
	@GetMapping("/{id}")
	public WorkerResponse findByid(@PathVariable Long id) {
		return this.workerService.findById(id);
	}
	
}
