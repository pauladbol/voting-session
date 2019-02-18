package br.com.tecchallenge.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Subject implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private long id;
	private String subject;
	
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
	
}
