package br.com.jt.commons.protocols.worker;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.jt.commons.entities.worker.Worker;
import br.com.jt.commons.protocols.ProtocolRequest;
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
public class WorkerRequest implements Serializable, ProtocolRequest {

	private static final long serialVersionUID = 206116065657039618L;
	private Long id;
	private String name;
	private BigDecimal dailyIncome;

	public static WorkerRequest encode(Worker worker) {
		return new ModelMapper().map(worker, WorkerRequest.class);
	}

	public static List<WorkerRequest> encode(List<Worker> workers) {
		return workers.stream().map(worker -> encode(worker))//
				.collect(Collectors.toList());
	}

}
