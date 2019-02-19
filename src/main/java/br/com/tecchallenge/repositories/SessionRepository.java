package br.com.tecchallenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tecchallenge.models.Session;

public interface SessionRepository extends JpaRepository<Session, Long>{
	Session findById(long id);

}
