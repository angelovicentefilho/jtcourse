package br.com.jt.commons.protocols.user;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.jt.commons.entities.user.User;
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
public class UserRequest implements Serializable, ProtocolRequest {

	private static final long serialVersionUID = -4536251842268663889L;
	private Long id;
	private String name;
	private String email;
	private String password;
	private List<RoleRequest> roles;

	public static UserRequest encode(User user) {
		return new ModelMapper().map(user, UserRequest.class);
	}

	public static List<UserRequest> decode(List<User> users) {
		return users.stream().map(user -> encode(user))//
				.collect(Collectors.toList());
	}
}
