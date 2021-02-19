package br.com.jt.user.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.jt.commons.protocols.user.UserRequest;
import br.com.jt.commons.protocols.user.UserResponse;
import br.com.jt.user.services.UserServiceApi;

@RefreshScope
@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserResource {

	private final UserServiceApi userService;
	
	@Autowired
	public UserResource(UserServiceApi userService) {
		this.userService = userService;
	}
	
	@GetMapping("/{id}")
	public UserResponse findById(@PathVariable Long id) {
		return this.userService.findById(id);
	}
	
	@PostMapping
	public UserResponse save(@RequestBody UserRequest request) {
		return this.userService.save(request);
	}
	
	@PutMapping
	public UserResponse update(@RequestBody UserRequest request) {
		return this.userService.update(request);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		this.userService.delete(id);
	}
	
	@GetMapping
	public UserResponse findAll() {
		return this.userService.findAll();
	}
	
	@GetMapping("/email")
	public UserResponse findByEmail(@RequestParam String email) {
		return this.userService.findByEmail(email);
	}
	
}
