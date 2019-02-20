package br.com.tecchallenge.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tecchallenge.models.Session;
import br.com.tecchallenge.repositories.SessionRepository;

@Service
public class SessionService {
	
	private SessionRepository sessionRepository;

	@Autowired
	public SessionService(SessionRepository sessionRepository) {
		super();
		this.setSessionRepository(sessionRepository);
	}
	
	public List<Session> listSessions(){
		return sessionRepository.findAll();
	}
	
	public Session findSession(long id){
		return sessionRepository.findById(id);
	}
	
	public Session saveSession(Session session) {
		return sessionRepository.save(session);
		
	}

	public void deleteSession(Session session) {
		sessionRepository.delete(session);
	}
	
	public Session updateSession(Session session) {
		return sessionRepository.save(session);
	}
	
	public SessionRepository getSessionRepository() {
		return sessionRepository;
	}

	public void setSessionRepository(SessionRepository sessionRepository) {
		this.sessionRepository = sessionRepository;
	}

}
