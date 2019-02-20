package br.com.tecchallenge.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="tb_vote")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Vote {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@NotNull
	private boolean vote;
	
	@ManyToOne
    @JoinColumn(name = "userId")
	@JsonIgnore
	private User userId;
	
	@ManyToOne
	@JoinColumn(name = "subjectId")
//	@JsonIgnore
	private Subject subjectId;
	
	
	public Vote() {
		super();
	}

	public Vote(long id, boolean vote, User user) {
		super();
		this.id = id;
		this.vote = vote;
		this.userId = user;
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
		return userId;
	}

	public void setUser(User user) {
		this.userId = user;
	}

	public Subject getSubject() {
		return subjectId;
	}

	public void setSubject(Subject subject) {
		this.subjectId = subject;
	}

	
}
