package br.com.tecchallenge.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tecchallenge.exceptions.ValidationException;
import br.com.tecchallenge.models.Session;
import br.com.tecchallenge.models.Subject;
import br.com.tecchallenge.models.Vote;
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

	public boolean isSessionOpen(long id) {
		Date now = new Date();
		
		Subject currentSubject = subjectRepository.findById(id);
		
		Session currentSession = currentSubject.getSession();
	
		if (currentSession.getSessionBegin().compareTo(now) < 0 && 
				currentSession.getSessionEnd().compareTo(now) > 0) {
			return true;
		}
		
		return false;
	}
	
	public boolean didUserVote(long idSubject, long idUser) {
		Subject currentSubject = subjectRepository.findById(idSubject);
		
		List<Vote> votes = currentSubject.getVotes();
		
		if (votes.stream().anyMatch(vote -> vote.getUser().getId() == idUser)){
			return true;
		}
		
		return false;
	}

	public Subject findSubjectResult(long id) {
		Subject currentSubject = subjectRepository.findById(id);
		
		if (isSessionOpen(id))
		throw new ValidationException("Sessão " + currentSubject.getSession().getId() + 
				" está aberta, não é possível contabilizar os votos.");
		
		List<Vote> votes = currentSubject.getVotes();
		
		long votesYes = (votes.stream().filter(vote -> vote.isVote())).count();
		
		long votesNo = (votes.stream().filter(vote -> !vote.isVote())).count();
		
		if (votesYes > votesNo) {
			currentSubject.setSubjectResult("Pauta Aprovada");
			
		} else {
			currentSubject.setSubjectResult("Pauta Reprovada");
		}
		
		return currentSubject;
		
	}

}
