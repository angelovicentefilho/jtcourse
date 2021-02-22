package br.com.jt.worker.validator;

import java.util.Optional;

import org.springframework.stereotype.Component;

import br.com.jt.commons.entities.worker.Worker;
import br.com.jt.commons.exceptions.WorkerNotFoundException;
import br.com.jt.commons.validator.JtValidator;

@Component
public class WorkerValidator implements JtValidator<Worker>{

	@Override
	public Worker has(Optional<Worker> obj) {
		obj.orElseThrow(() -> new WorkerNotFoundException("Trabalhador não encontrado!!"));
		return obj.get();
	}

}
