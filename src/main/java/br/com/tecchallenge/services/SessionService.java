package br.com.tecchallenge.services;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tecchallenge.models.Session;
import br.com.tecchallenge.models.Vote;
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
	
	
	
	public boolean isSessionOpen(long id) {
		Date now = new Date();
		
		Session currentSession = sessionRepository.findById(id);
	
		if (currentSession.getSessionBegin().compareTo(now) < 0 && 
				currentSession.getSessionEnd().compareTo(now) > 0) {
			return true;
		}
		
		return false;
	}
	
	public boolean didUserVote(long idSession, long idUser) {
		Session currentSession = sessionRepository.findById(idSession);
		
		List<Vote> votes = currentSession.getVotes();
		
		if (votes.stream().anyMatch(vote -> vote.getUser().getId() == idUser)){
			return true;
		}
		
		return false;
	}

	public long findSessionResult(long id) {
		Session currentSession = sessionRepository.findById(id);
		
		List<Vote> votes = currentSession.getVotes();
		
		Stream<Vote> votesYes = votes.stream().filter(vote -> vote.isVote());
		
		votesYes.count();
		
		Stream<Vote> votesNo = votes.stream().filter(vote -> !vote.isVote());
		
		if (votesYes.count() > votesNo.count()) {
			return votesYes.count();
		} else {
			return votesNo.count();
		}

	}

}
