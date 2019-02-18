package br.com.tecchallenge.services.implementations;

import java.util.ArrayList;
import java.util.List;
//import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.tecchallenge.models.Session;
import br.com.tecchallenge.services.SessionService;

@Service
public class SessionServiceImpl implements SessionService{
	
//	private final AtomicLong counter = new AtomicLong();

	@Override
	public Session create(Session session) {
		return session;
	}

	@Override
	public Session findById(String sessionId) {
		Session session = new Session();
		
		
		return session;
	}

	@Override
	public List<Session> findAll() {
		ArrayList<Session> sessions = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
        	Session session = mockSessions(i);
        	sessions.add(session);
        }
        return sessions;
	}

	@Override
	public Session update(Session session) {
		return session;
	}

	@Override
	public void delete(String sessionId) {
				
	}
	
	private Session mockSessions(int i) {
		Session session = new Session();

	    return session;
	}

}
