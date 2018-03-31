package com.example.rest.springrestws.hateoas;

import static  org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import java.net.URI;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
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
import com.example.rest.springrestws.StaticUser.User;
import com.example.rest.springrestws.StaticUser.UserDaoService;

@RestController
public class UserResourceHateoas {

	@Autowired
	private UserDaoService userDaoService;

	// find All user
	@GetMapping(path = "/usersh")
	public List<User> findAllUser() {
		return userDaoService.findAll();
	}

	// find single user
	@GetMapping(path = "/usersh/{id}")
	public Resource<User> findById(@PathVariable Integer id) {
		User user=userDaoService.findOne(id);
		if(user==null)
			throw new UserNotFound("id-"+id);
		//"alluser", serverpath + "/users"
		//findalluser
		//HATEOAS Concept
		
		Resource<User> resource = new Resource<User>(user);
		ControllerLinkBuilder linkto=linkTo(methodOn(this.getClass()).findAllUser());
		resource.add(linkto.withRel("all-user"));
		return resource;
	}
	
	// find delete user
		@DeleteMapping(path = "/usersh/{id}")
		public User deleteById(@PathVariable Integer id) {
			User user=userDaoService.deleteById(id);
			if(user==null)
				throw new UserNotFound("id-"+id);
			return user;
		}

	// save user
	@PostMapping(path = "/usersh")
	public ResponseEntity<Object> saveuser(@Valid @RequestBody User user) {
		User saveuser = userDaoService.save(user);
		// created
		// /users/{id} saveuser.getId()
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveuser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
}
