package br.com.jt.payroll.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.jt.commons.protocols.payment.PaymentResponse;
import br.com.jt.payroll.services.PaymentService;

@RestController
@CrossOrigin
public class PaymentResource {

	private final PaymentService _service;

	@Autowired
	public PaymentResource(final PaymentService service) {
		this._service = service;
	}

	@HystrixCommand(fallbackMethod = "paymentFallback")
	@GetMapping(value = "/{workerId}/days/{days}")
	public PaymentResponse payment(@PathVariable Long workerId, @PathVariable Integer days) {
		return this._service.payment(workerId, days);
	}

	public PaymentResponse paymentFallback(Long workerId, Integer id) {
		throw new RuntimeException("O serviço de pagamento está fora do ar!!");
	}
	
}
