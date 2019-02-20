package br.com.tecchallenge.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
	
	@OneToOne (cascade = CascadeType.ALL)
	@JoinColumn(name = "subjectId")
	@JsonIgnore
	private Subject subjectId;
	
	public Session() {
		super();
	}	

	public Session(Date sessionBegin, Date sessionEnd, String sessionResult, Subject subject) {
		super();
		this.sessionBegin = sessionBegin;
		this.sessionEnd = sessionEnd;
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
	
}
