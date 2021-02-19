package br.com.jt.user.validator;

import java.io.Serializable;
import java.util.Optional;

import br.com.jt.commons.entities.user.User;
import br.com.jt.commons.exceptions.UserNotFoundException;
import br.com.jt.commons.validator.JtValidator;

public class UserValidator implements Serializable, JtValidator<User> {

	private static final long serialVersionUID = 7658060453794851421L;
	private static final String UNKNOW_USER = "Usuário não encontrado.";

	@Override
	public User has(Optional<User> optional) {
		optional.orElseThrow(() -> new UserNotFoundException(UNKNOW_USER));
		return optional.get();
	}

	
	

}
