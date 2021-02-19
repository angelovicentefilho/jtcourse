package br.com.jt.commons.entities.user;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;
import org.springframework.ui.ModelMap;

import br.com.jt.commons.protocols.user.RoleRequest;
import br.com.jt.commons.protocols.user.RoleResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "roles")
public class Role implements Serializable {
	private static final long serialVersionUID = -363160531158162459L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	public static Role decode(RoleRequest request) {
		return new ModelMapper().map(request, Role.class);
	}
	
	public static Role decode(RoleResponse response) {
		return new ModelMapper().map(response, Role.class);
	}

}
