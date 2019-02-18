package br.com.tecchallenge.services.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.tecchallenge.models.Subject;
import br.com.tecchallenge.services.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService{
	
	private final AtomicLong counter = new AtomicLong();
	
	@Override
	public Subject create(Subject subject) {
		return subject;
	}

	@Override
	public Subject findById(String subjectId) {
		Subject subject = new Subject(counter.incrementAndGet(), "Pauta 1");

        return subject;
	}

	@Override
	public List<Subject> findAll() {
		ArrayList<Subject> subjects = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
        	Subject subject = mockSubject(i);
        	subjects.add(subject);
        }
        return subjects;
	}

	@Override
	public Subject update(Subject subject) {
		return subject;
	}

	@Override
	public void delete(String subjectId) {
		// TODO Auto-generated method stub
		
	}
	
	private Subject mockSubject(int i) {
		Subject person = new Subject(counter.incrementAndGet(), "Pauta 1");

	    return person;
	}
}
