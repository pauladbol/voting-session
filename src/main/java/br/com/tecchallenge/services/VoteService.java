package br.com.tecchallenge.services;

import java.util.List;

import br.com.tecchallenge.models.Vote;

public interface VoteService {
	Vote create(final Vote vote);
	Vote findById(final String voteId);
    List<Vote> findAll();
    Vote update(Vote vote);
    void delete(final String vote);
}
