package br.com.tecchallenge.models;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="tb_subject")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Subject implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@NotNull
	private String subject;
	
	@OneToMany(mappedBy="subjectId", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Session> sessions;
	
	public Subject() {
		super();
	}

	public Subject(long id, String subject) {
		super();
		this.id = id;
		this.subject = subject;
	}
	
	public long getId() {
		return id;
	}
	public String getSubject() {
		return subject;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setSubject(String string) {
		this.subject = string;
	}

	public List<Session> getSessions() {
		return sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}	
	
}
