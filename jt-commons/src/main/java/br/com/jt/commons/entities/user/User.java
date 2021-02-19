package br.com.jt.commons.entities.user;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import br.com.jt.commons.protocols.user.UserRequest;
import br.com.jt.commons.protocols.user.UserResponse;
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
@Table(name = "users")
public class User implements Serializable {

	private static final long serialVersionUID = 1868410846327094940L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@Column(unique = true)
	private String email;
	private String password;

	@JoinTable(name = "users_has_roles",// 
			joinColumns = @JoinColumn(name = "user_id"),//
			inverseJoinColumns = @JoinColumn(name = "role_id")//
	)
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Role> roles;
	
	public static User decode(UserRequest request) {
		return new ModelMapper().map(request, User.class);
	}
	
	public static User decode(UserResponse response) {
		return new ModelMapper().map(response, User.class);
	}

}
