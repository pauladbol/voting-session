package br.com.tecchallenge.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tecchallenge.exceptions.ValidationException;
import br.com.tecchallenge.models.Vote;
import br.com.tecchallenge.repositories.VoteRepository;

@Service
public class VoteService {
	
	private VoteRepository voteRepository;
	private SubjectService subjectService;

	@Autowired
	public VoteService(VoteRepository voteRepository, SubjectService subjectService) {
		super();
		this.setVoteRepository(voteRepository);
		this.subjectService = subjectService;
	}
	
	public List<Vote> listVotes(){
		return voteRepository.findAll();
	}
	
	public Vote findVote(long id){
		return voteRepository.findById(id);
	}
	
	public Vote saveVote(Vote vote) {
		long idSubject = vote.getSubject().getId();
		long idUser = vote.getUser().getId();
		
		if (!subjectService.isSessionOpen(idSubject))
			throw new ValidationException("Sessão " + vote.getSubject().getSession().getId() + 
											" está fechada, não é possível votar.");
			
		if(subjectService.didUserVote(idSubject, idUser))
			throw new ValidationException("Usuário " + vote.getUser().getUsername() + 
											" já votou.");
		
		return voteRepository.save(vote);
		
	}

	public void deleteVote(Vote vote) {
		voteRepository.delete(vote);
	}
	
	public Vote updateVote(Vote vote) {
		return voteRepository.save(vote);
	}
	
	public VoteRepository getVoteRepository() {
		return voteRepository;
	}

	public void setVoteRepository(VoteRepository voteRepository) {
		this.voteRepository = voteRepository;
	}

}
