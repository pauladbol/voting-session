package br.com.tecchallenge.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tecchallenge.models.Vote;
import br.com.tecchallenge.repositories.VoteRepository;
import br.com.tecchallenge.services.SessionService;

@Service
public class VoteService {
	
	private VoteRepository voteRepository;
	private SessionService sessionService;

	@Autowired
	public VoteService(VoteRepository voteRepository, SessionService sessionService) {
		super();
		this.setVoteRepository(voteRepository);
		this.sessionService = sessionService;
	}
	
	public List<Vote> listVotes(){
		return voteRepository.findAll();
	}
	
	public Vote findVote(long id){
		return voteRepository.findById(id);
	}
	
	public Vote saveVote(Vote vote) {
		long idSession = vote.getSession().getId();
		long idUser = vote.getUser().getId();
		
		if (sessionService.isSessionOpen(idSession) &&
				!sessionService.didUserVote(idSession, idUser)) {
			return voteRepository.save(vote);
		}
		
		return null;
		
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
