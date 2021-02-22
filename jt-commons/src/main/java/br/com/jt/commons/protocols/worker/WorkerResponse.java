package br.com.jt.commons.protocols.worker;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.jt.commons.entities.user.User;
import br.com.jt.commons.entities.worker.Worker;
import br.com.jt.commons.protocols.ProtocolResponse;
import br.com.jt.commons.protocols.user.UserResponse;
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
public class WorkerResponse implements Serializable, ProtocolResponse {

	private static final long serialVersionUID = -8471064894600082007L;
	private Long id;
	private String name;
	private BigDecimal dailyIncome;

	private List<WorkerResponse> workers;

	public static WorkerResponse encode(Worker worker) {
		return new ModelMapper().map(worker, WorkerResponse.class);
	}

	public static List<WorkerResponse> encodeList(List<Worker> workers) {
		return workers.stream().map(worker -> encode(worker))//
				.collect(Collectors.toList());
	}
	
	public static WorkerResponse encode(List<Worker> workers) {
		return WorkerResponse.newInstance().withWorkers(encodeList(workers)).build();
	}
}
