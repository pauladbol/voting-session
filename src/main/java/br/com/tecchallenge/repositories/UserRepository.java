package br.com.tecchallenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tecchallenge.models.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findById(long id);

}
