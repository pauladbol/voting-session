package br.com.tecchallenge.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tecchallenge.exceptions.ResourceNotFoundException;
import br.com.tecchallenge.exceptions.ValidationException;
import br.com.tecchallenge.models.Session;
import br.com.tecchallenge.models.Vote;
import br.com.tecchallenge.repositories.UserRepository;
import br.com.tecchallenge.repositories.VoteRepository;

@Service
public class VoteService {
	
	private VoteRepository voteRepository;
	private SubjectService subjectService;
	private UserRepository userRepository;

	@Autowired
	public VoteService(VoteRepository voteRepository, SubjectService subjectService, UserRepository userRepository) {
		super();
		this.setVoteRepository(voteRepository);
		this.subjectService = subjectService;
		this.userRepository = userRepository;
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
		
		if (userRepository.findById(vote.getUser().getId()) == null)
			throw new ResourceNotFoundException("Usuário " + vote.getUser().getId() + " não encontrado.");
		
		if (subjectService.findSubject(vote.getSubject().getId()) == null)
			throw new ResourceNotFoundException("Pauta " + vote.getSubject().getId() + " não encontrada.");
		
		if (!subjectService.isSessionOpen(idSubject))
			throw new ValidationException("Sessão está fechada, não é possível votar.");

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
