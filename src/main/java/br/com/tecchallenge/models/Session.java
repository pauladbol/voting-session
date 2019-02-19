package br.com.tecchallenge.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tb_session")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Session {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@NotNull
	private Date sessionBegin;
	
	@NotNull
	private Date sessionEnd;
	
	private String sessionResult;
	
	@ManyToOne
	@JoinColumn(name = "subjectId")
	@JsonIgnore
	private Subject subjectId;
	
	@OneToMany(mappedBy="session", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Vote> votes;
	
	public Session() {
		super();
	}	

	public Session(Date sessionBegin, Date sessionEnd, String sessionResult, Subject subject) {
		super();
		this.sessionBegin = sessionBegin;
		this.sessionEnd = sessionEnd;
		this.sessionResult = sessionResult;
		this.subjectId = subject;
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

	public String getSessionResult() {
		return sessionResult;
	}

	public void setSessionResult(String sessionResult) {
		this.sessionResult = sessionResult;
	}

	public Subject getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Subject subjectId) {
		this.subjectId = subjectId;
	}

	public Subject getSubject() {
		return subjectId;
	}

	public void setSubject(Subject subject) {
		this.subjectId = subject;
	}

	public List<Vote> getVotes() {
		return votes;
	}

	public void setVotes(List<Vote> votes) {
		this.votes = votes;
	}
	
	
}
