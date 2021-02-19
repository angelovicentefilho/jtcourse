package br.com.jt.commons.protocols.user;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.jt.commons.entities.user.Role;
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
public class RoleRequest implements Serializable, ProtocolRequest {

	private static final long serialVersionUID = 8762371745536904691L;
	private Long id;
	private String name;

	public static RoleRequest encode(Role role) {
		return new ModelMapper().map(role, RoleRequest.class);
	}

	public static List<RoleRequest> encode(List<Role> roles) {
		return roles.stream().map(role -> encode(role))//
				.collect(Collectors.toList());
	}
}
