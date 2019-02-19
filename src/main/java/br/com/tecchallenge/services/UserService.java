package br.com.tecchallenge.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tecchallenge.models.User;
import br.com.tecchallenge.repositories.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		super();
		this.setUserRepository(userRepository);
	}
	
	public List<User> listUsers(){
		return userRepository.findAll();
	}
	
	public User findUser(long id){
		return userRepository.findById(id);
	}
	
	public User saveUser(User user) {
		return userRepository.save(user);
		
	}

	public void deleteUser(User user) {
		userRepository.delete(user);
	}
	
	public User updateUser(User user) {
		return userRepository.save(user);
	}
	
	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
}
