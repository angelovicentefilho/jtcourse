package br.com.jt.commons.protocols.user;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.jt.commons.entities.user.Role;
import br.com.jt.commons.protocols.ProtocolResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder(builderMethodName = "newInstance", setterPrefix = "with")
@JsonInclude(Include.NON_NULL)
public class RoleResponse implements Serializable, ProtocolResponse {
	private static final long serialVersionUID = 2800086654552943812L;
	private Long id;
	private String name;

	List<RoleResponse> roles;

	public static RoleResponse encode(Role role) {
		return new ModelMapper().map(role, RoleResponse.class);
	}

	public static List<RoleResponse> encode(List<Role> roles) {
		return roles.stream().map(role -> encode(role))//
				.collect(Collectors.toList());
	}
}
