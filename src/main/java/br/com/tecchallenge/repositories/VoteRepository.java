package br.com.tecchallenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tecchallenge.models.Vote;

public interface VoteRepository extends JpaRepository<Vote, Long>{
	Vote findById(long id);

}
