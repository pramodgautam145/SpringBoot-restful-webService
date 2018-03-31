package com.example.rest.springrestws.StaticUser;

import java.net.URI;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.rest.springrestws.Exception.UserNotFound;

@RestController
public class UserResource {

	@Autowired
	private UserDaoService userDaoService;

	// find All user
	@GetMapping(path = "/users")
	public List<User> findAllUser() {
		return userDaoService.findAll();
	}

	// find single user
	@GetMapping(path = "/users/{id}")
	public User findById(@PathVariable Integer id) {
		User user=userDaoService.findOne(id);
		if(user==null)
			throw new UserNotFound("id-"+id);
		return user;
	}
	
	// find delete user
		@DeleteMapping(path = "/users/{id}")
		public User deleteById(@PathVariable Integer id) {
			User user=userDaoService.deleteById(id);
			if(user==null)
				throw new UserNotFound("id-"+id);
			return user;
		}

	// save user
	@PostMapping(path = "/users")
	public ResponseEntity<Object> saveuser(@RequestBody User user) {
		User saveuser = userDaoService.save(user);
		// created
		// /users/{id} saveuser.getId()
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveuser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
		
	/*	@PostMapping(path = "/users")
		public void saveuser(@RequestBody User user) {
			User saveuser = userDaoService.save(user);
			// created
			// /users/{id} saveuser.getId()
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveuser.getId())
					.toUri();
			
		}
*/
	
}
