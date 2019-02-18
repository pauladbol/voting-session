package br.com.tecchallenge.models;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Session {
	
	private long id;
	private Date sessionBegin;
	private Date sessionEnd;
	private Subject subject;
	private List<Vote> votes;
	
	public Session() {
		super();
	}	

	public Session(Date sessionBegin, Date sessionEnd, Subject subject) {
		super();
		this.sessionBegin = sessionBegin;
		this.sessionEnd = sessionEnd;
		this.subject = subject;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public Date getSessionBegin() {
		return sessionBegin;
	}

	public void setSessionBegin(Date sessionBegin) {
		this.sessionBegin = sessionBegin;
	}

	public Date getSessionEnd() {
		return sessionEnd;
	}

	public void setSessionEnd(Date sessionEnd) {
		this.sessionEnd = sessionEnd;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public List<Vote> getVotes() {
		return votes;
	}

	public void setVotes(List<Vote> votes) {
		this.votes = votes;
	}
	
	
}
