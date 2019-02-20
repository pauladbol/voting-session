package br.com.tecchallenge.models;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="tb_subject")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Subject implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	

	private String subject;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Session session;
	
	@OneToMany(mappedBy="subjectId", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Vote> votes;
	
	@Transient
	private String subjectResult;
	
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

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public List<Vote> getVotes() {
		return votes;
	}

	public void setVotes(List<Vote> votes) {
		this.votes = votes;
	}

	public String getSubjectResult() {
		return subjectResult;
	}

	public void setSubjectResult(String subjectResult) {
		this.subjectResult = subjectResult;
	}	
	
	
	
}
