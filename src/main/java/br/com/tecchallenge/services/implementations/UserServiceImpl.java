package br.com.tecchallenge.services.implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.tecchallenge.models.User;
import br.com.tecchallenge.services.UserService;

@Service
public class UserServiceImpl implements UserService {

//	private final AtomicLong counter = new AtomicLong();

	@Override
	public User create(User user) {
		return user;
	}

	@Override
	public User findById(String userId) {
		User user = new User();
		
		
		return user;
	}

	@Override
	public List<User> findAll() {
		ArrayList<User> users = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
        	User user = mockUsers(i);
        	users.add(user);
        }
        return users;
	}

	@Override
	public User update(User user) {
		return user;
	}

	@Override
	public void delete(String userId) {
				
	}
	
	private User mockUsers(int i) {
		User user = new User();

	    return user;
	}
}
