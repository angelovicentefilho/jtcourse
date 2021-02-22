package br.com.jt.worker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.jt.commons.entities.worker.Worker;
import br.com.jt.commons.protocols.worker.WorkerResponse;
import br.com.jt.worker.repository.WorkerRepository;
import br.com.jt.worker.validator.WorkerValidator;

@Service
@Transactional
public class WorkerServiceImpl implements WorkerService {

	private final WorkerRepository repository;
	private final WorkerValidator validator;
	
	@Autowired
	public WorkerServiceImpl(WorkerRepository repository, WorkerValidator validator) {
		this.repository = repository;
		this.validator = validator;
	}
	
	@Override
	public WorkerResponse findById(Long id) {
		Worker worker = validator.has(repository.findById(id));
		return WorkerResponse.encode(worker);
	}

	@Override
	public WorkerResponse findAll() {
		return WorkerResponse.encode(repository.findAll());
	}

}
