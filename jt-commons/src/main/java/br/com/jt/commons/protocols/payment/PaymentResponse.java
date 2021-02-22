package br.com.jt.commons.protocols.payment;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.jt.commons.protocols.ProtocolResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(builderMethodName = "newInstance", setterPrefix = "with")
@JsonInclude(Include.NON_NULL)
public class PaymentResponse implements ProtocolResponse, Serializable {
	private static final long serialVersionUID = 2370667044838518677L;
	private String name;
	private BigDecimal dailyIncome;
	private Integer days;
	
	public BigDecimal getTotal() {
		return dailyIncome.multiply(new BigDecimal(days));
	}

}
