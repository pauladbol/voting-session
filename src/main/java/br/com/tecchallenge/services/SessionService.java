package br.com.tecchallenge.services;

import java.util.List;

import br.com.tecchallenge.models.Session;

public interface SessionService {
	Session create(final Session session);
	Session findById(final String sessionId);
    List<Session> findAll();
    Session update(Session session);
    void delete(final String sessionId);
}
