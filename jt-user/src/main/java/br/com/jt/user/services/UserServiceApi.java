package br.com.jt.user.services;

import br.com.jt.commons.protocols.user.UserRequest;
import br.com.jt.commons.protocols.user.UserResponse;

public interface UserServiceApi {

	UserResponse save(UserRequest request);

	UserResponse update(UserRequest request);

	void delete(Long id);

	UserResponse findAll();

	UserResponse findById(Long id);
	
	UserResponse findByEmail(String email);

}
