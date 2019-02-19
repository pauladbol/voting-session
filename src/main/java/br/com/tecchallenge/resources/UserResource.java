package br.com.tecchallenge.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tecchallenge.models.User;
import br.com.tecchallenge.services.UserService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api")
public class UserResource {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/users")
	public List<User> listUsers(){
		return userService.listUsers();
	}
	
	@GetMapping("/user/{id}")
	public User findUser(@PathVariable(value="id") long id){
		return userService.findUser(id);
	}
	
	@PostMapping("/user")
	public User saveUser(@RequestBody @Valid User user) {
		return userService.saveUser(user);
	}
	
	@DeleteMapping("/user")
	public void deleteUser(@RequestBody @Valid User user) {
		userService.deleteUser(user);
	}
	
	@PutMapping("/user")
	public User updateUser(@RequestBody @Valid User user) {
		return userService.updateUser(user);
	}
	 

}
