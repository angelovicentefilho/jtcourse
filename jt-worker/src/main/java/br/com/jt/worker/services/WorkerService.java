package br.com.jt.worker.services;

import br.com.jt.commons.protocols.worker.WorkerResponse;

public interface WorkerService {

	WorkerResponse findById(Long id);
	
	WorkerResponse findAll();
	
}
