package br.com.tecchallenge.services.implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.tecchallenge.models.Vote;
import br.com.tecchallenge.services.VoteService;

@Service
public class VoteServiceImpl implements VoteService{

//	private final AtomicLong counter = new AtomicLong();

	@Override
	public Vote create(Vote vote) {
		return vote;
	}

	@Override
	public Vote findById(String voteId) {
		Vote vote = new Vote();
		
		return vote;
	}

	@Override
	public List<Vote> findAll() {
		ArrayList<Vote> votes = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
        	Vote vote = mockVotes(i);
        	votes.add(vote);
        }
        return votes;
	}

	@Override
	public Vote update(Vote vote) {
		return vote;
	}

	@Override
	public void delete(String voteId) {
				
	}
	
	private Vote mockVotes(int i) {
		Vote vote = new Vote();

	    return vote;
	}
}
