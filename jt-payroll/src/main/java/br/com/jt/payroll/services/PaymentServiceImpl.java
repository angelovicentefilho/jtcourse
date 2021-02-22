package br.com.jt.payroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jt.commons.entities.worker.Worker;
import br.com.jt.commons.protocols.payment.PaymentResponse;
import br.com.jt.payroll.clients.WorkerFeingClient;

@Service
public class PaymentServiceImpl implements PaymentService {

	private final WorkerFeingClient _client;
	
	@Autowired
	public PaymentServiceImpl(final WorkerFeingClient client) {
		this._client = client;
	}
	
	@Override
	public PaymentResponse payment(Long workerId, int days) {
		Worker worker = Worker.decode(this._client.findById(workerId));
		return new PaymentResponse(worker.getName(), worker.getDailyIncome(), days);
	}

}
