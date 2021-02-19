package br.com.jt.user.services;

import br.com.jt.commons.entities.user.User;

public interface UserService extends UserServiceApi {

	User findUserByEmail(String email);
	
}
