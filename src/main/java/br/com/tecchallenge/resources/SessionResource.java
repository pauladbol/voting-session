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
import br.com.tecchallenge.repositories.SessionRepository;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api")
public class SessionResource {
	
	@Autowired
	SessionRepository sessionRepository;
	
	@GetMapping("/sessions")
	public List<Session> listSessions(){
		return sessionRepository.findAll();
	}
	
	@GetMapping("/session/{id}")
	public Session findSession(@PathVariable(value="id") long id){
		return sessionRepository.findById(id);
	}
	
	@PostMapping("/session")
	public Session saveSession(@RequestBody @Valid Session session) {
		return sessionRepository.save(session);
	}
	
	@DeleteMapping("/session")
	public void deleteSession(@RequestBody @Valid Session session) {
		sessionRepository.delete(session);
	}
	
	@PutMapping("/session")
	public Session updateSession(@RequestBody @Valid Session session) {
		return sessionRepository.save(session);
	}
	 

}
