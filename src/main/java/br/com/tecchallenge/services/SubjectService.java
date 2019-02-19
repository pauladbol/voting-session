package br.com.tecchallenge.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tecchallenge.models.Subject;
import br.com.tecchallenge.repositories.SubjectRepository;

@Service
public class SubjectService {
	
	private SubjectRepository subjectRepository;

	@Autowired
	public SubjectService(SubjectRepository subjectRepository) {
		super();
		this.setSubjectRepository(subjectRepository);
	}
	
	public List<Subject> listSubjects(){
		return subjectRepository.findAll();
	}
	
	public Subject findSubject(long id){
		return subjectRepository.findById(id);
	}
	
	public Subject saveSubject(Subject subject) {
		return subjectRepository.save(subject);
		
	}

	public void deleteSubject(Subject subject) {
		subjectRepository.delete(subject);
	}
	
	public Subject updateSubject(Subject subject) {
		return subjectRepository.save(subject);
	}
	
	public SubjectRepository getSubjectRepository() {
		return subjectRepository;
	}

	public void setSubjectRepository(SubjectRepository subjectRepository) {
		this.subjectRepository = subjectRepository;
	}

}
