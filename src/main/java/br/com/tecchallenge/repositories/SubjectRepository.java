package br.com.tecchallenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tecchallenge.models.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long>{
	Subject findById(long id);

}
