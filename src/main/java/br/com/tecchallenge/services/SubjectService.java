package br.com.tecchallenge.services;

import java.util.List;

import br.com.tecchallenge.models.Subject;

public interface SubjectService {
	
	Subject create(final Subject subject);
	Subject findById(final String subjectId);
    List<Subject> findAll();
    Subject update(Subject subject);
    void delete(final String subjectId);

}
