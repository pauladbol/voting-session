package br.com.tecchallenge.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tecchallenge.models.Session;
import br.com.tecchallenge.services.SessionService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api")
public class SessionResource {
	
	@Autowired
	SessionService sessionService;
	
	@GetMapping("/sessions")
	public List<Session> listSessions(){
		return sessionService.listSessions();
	}
	
	@GetMapping("/session/{id}")
	public Session findSession(@PathVariable(value="id") long id){
		return sessionService.findSession(id);
	}
	
	@PostMapping("/session")
	public Session saveSession(@RequestBody @Valid Session session) {
		return sessionService.saveSession(session);
	}
	
	@DeleteMapping("/session")
	public void deleteSession(@RequestBody @Valid Session session) {
		sessionService.deleteSession(session);
	}
	
	@PutMapping("/session")
	public Session updateSession(@RequestBody @Valid Session session) {
		return sessionService.updateSession(session);
	}
	
	@GetMapping("/session/{id}/result")
	public long findSessionResult(@PathVariable(value="id") long id){
		return sessionService.findSessionResult(id);
	}

}
