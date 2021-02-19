package br.com.jt.user.services;

import static org.springframework.transaction.annotation.Propagation.SUPPORTS;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.jt.commons.entities.user.User;
import br.com.jt.commons.exceptions.UserNotFoundException;
import br.com.jt.commons.protocols.user.UserRequest;
import br.com.jt.commons.protocols.user.UserResponse;
import br.com.jt.user.repository.UserRepository;
import br.com.jt.user.validator.UserValidator;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	private final UserRepository repository;
	private final UserValidator validator;
	
	@Autowired
	public UserServiceImpl(UserRepository repository, UserValidator validator) {
		this.repository = repository;
		this.validator = validator;
	}

	@Override
	public UserResponse save(UserRequest request) {
		return UserResponse.encode(repository.save(User.decode(request)));
	}

	@Override
	public UserResponse update(UserRequest request) {
		User user = validator.has(repository.findById(request.getId()));
		return UserResponse.encode(repository.save(user));
	}

	@Override
	public void delete(Long id) {
		validator.has(repository.findById(id));
		repository.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true, propagation = SUPPORTS)
	public UserResponse findAll() {
		return UserResponse.encode(repository.findAll());
	}

	@Override
	@Transactional(readOnly = true, propagation = SUPPORTS)
	public UserResponse findById(Long id) {
		User user = validator.has(repository.findById(id));
		return UserResponse.encode(user);
	}

	@Override
	@Transactional(readOnly = true, propagation = SUPPORTS)
	public User findUserByEmail(String email) {
		return repository.findByEmail(email);
	}

	@Override
	@Transactional(readOnly = true, propagation = SUPPORTS)
	public UserResponse findByEmail(String email) {
		return UserResponse.encode(findUserByEmail(email));
	}
	
}
