package com.example.rest.springrestws.JpaDynamicexample;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.rest.springrestws.Exception.UserNotFound;
import com.example.rest.springrestws.StaticUser.User;

@RestController
public class JUserResource {

	

	@Autowired
	private JuserRepository juserRepository;
	
	@Autowired
	private JpostRepository JpostRepository;
	// find All user
	@GetMapping(path = "/jusers")
	public List<JUser> findAllUser() {
		return juserRepository.findAll();
	}

	// find single user
	@GetMapping(path = "/jusers/{id}")
	public Resource<JUser> findById(@PathVariable Integer id) {
		Optional<JUser> user=juserRepository.findById(id);
		if(!user.isPresent())
			throw new UserNotFound("id-"+id);
		
		Resource<JUser> resource = new Resource<JUser>(user.get());
		ControllerLinkBuilder linkto=linkTo(methodOn(this.getClass()).findAllUser());
		resource.add(linkto.withRel("all-user"));
		return resource;
		
	}
	
	// find delete user
		@DeleteMapping(path = "/jusers/{id}")
		public void deleteById(@PathVariable Integer id) {
			juserRepository.deleteById(id);
			
		}

	// save user
	@PostMapping(path = "/jusers")
	public ResponseEntity<Object> saveuser(@RequestBody JUser user) {
		JUser saveuser = juserRepository.save(user);
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
	
	//retrieve All post based on userid
	@GetMapping(path = "/jusers/{id}/posts")
	public List<JPost> retrieveAllUser(@PathVariable int id) {
		Optional<JUser> joptional= juserRepository.findById(id);
		if(!joptional.isPresent())
			throw new UserNotFound("id-"+id);
		
		 return joptional.get().getJposts();
	}
	
	//create post
	@PostMapping(path = "/jusers/{id}/posts")
	public ResponseEntity<Object> createPost(@PathVariable int id,@RequestBody JPost jpost) {
		Optional<JUser> joptional= juserRepository.findById(id);
		if(!joptional.isPresent())
			throw new UserNotFound("id-"+id);
		JUser juser= joptional.get();
		jpost.setJuser(juser);
		JpostRepository.save(jpost);
		// created
		// /users/{id} saveuser.getId()
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(juser)
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
}
