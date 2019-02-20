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

import br.com.tecchallenge.exceptions.ResourceNotFoundException;
import br.com.tecchallenge.models.User;
import br.com.tecchallenge.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api")
@Api(value="API REST Usuários")
public class UserResource {
	
	@Autowired
	UserService userService;
	
	@ApiOperation(value="Retorna uma lista de usuários")
	@GetMapping("/users")
	public List<User> listUsers(){
		return userService.listUsers();
	}
	
	@ApiOperation(value="Retorna um usuário")	
	@GetMapping("/user/{id}")
	public User findUser(@PathVariable(value="id") long id){
		if (userService.findUser(id) == null)
			throw new ResourceNotFoundException("Usuário " + id + " não encontrado.");
		return userService.findUser(id);
	}
	
	@ApiOperation(value="Salva um usuário")
	@PostMapping("/user")
	public User saveUser(@RequestBody @Valid User user) {
		return userService.saveUser(user);
	}
	
	@ApiOperation(value="Deleta um usuário")
	@DeleteMapping("/user")
	public void deleteUser(@RequestBody @Valid User user) {
		if (userService.findUser(user.getId()) == null)
			throw new ResourceNotFoundException("Usuário " + user.getId() + " não encontrado.");
		userService.deleteUser(user);
	}
	
	@ApiOperation(value="Altera um usuário")
	@PutMapping("/user")
	public User updateUser(@RequestBody @Valid User user) {
		if (userService.findUser(user.getId()) == null)
			throw new ResourceNotFoundException("Usuário " + user.getId() + " não encontrado.");
		return userService.updateUser(user);
	}
	 

}
