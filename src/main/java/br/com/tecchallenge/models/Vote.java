package br.com.tecchallenge.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Vote {
	
	private long id;
	private boolean vote;
	private User user;
	
	public Vote() {
		super();
	}

	public Vote(long id, boolean vote, User user) {
		super();
		this.id = id;
		this.vote = vote;
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public boolean isVote() {
		return vote;
	}

	public void setVote(boolean vote) {
		this.vote = vote;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
