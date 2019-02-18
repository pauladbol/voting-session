package br.com.tecchallenge.services;

import java.util.List;

import br.com.tecchallenge.models.User;

public interface UserService {
	User create(final User user);
	User findById(final String userId);
    List<User> findAll();
    User update(User user);
    void delete(final String userId);
}
