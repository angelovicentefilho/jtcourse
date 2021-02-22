package br.com.jt.payroll.services;

import br.com.jt.commons.protocols.payment.PaymentResponse;

public interface PaymentService {

	PaymentResponse payment(Long workerId, int days);

}
