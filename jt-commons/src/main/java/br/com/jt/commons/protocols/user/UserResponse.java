package br.com.jt.commons.protocols.user;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.jt.commons.entities.user.User;
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
public class UserResponse implements Serializable, ProtocolResponse {

	private static final long serialVersionUID = -1808436339695095913L;
	private Long id;
	private String name;
	private String email;
	private String password;
	private List<RoleResponse> roles;

	private List<UserResponse> users;

	public static UserResponse encode(User user) {
		return new ModelMapper().map(user, UserResponse.class);
	}

	public static List<UserResponse> decode(List<User> users) {
		return users.stream().map(user -> encode(user))//
				.collect(Collectors.toList());
	}
}
