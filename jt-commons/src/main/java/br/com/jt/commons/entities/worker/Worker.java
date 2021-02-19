package br.com.jt.commons.entities.worker;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import br.com.jt.commons.protocols.worker.WorkerRequest;
import br.com.jt.commons.protocols.worker.WorkerResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "workers")
public class Worker implements Serializable {
	private static final long serialVersionUID = -4326830724185989248L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private BigDecimal dailyIncome;
	
	public static Worker decode(WorkerRequest request) {
		return new ModelMapper().map(request, Worker.class);
	}
	
	public static Worker decode(WorkerResponse response) {
		return new ModelMapper().map(response, Worker.class);
	}
	
}
