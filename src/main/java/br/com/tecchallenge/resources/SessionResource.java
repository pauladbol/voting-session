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

import br.com.tecchallenge.exceptions.ResourceNotFoundException;
import br.com.tecchallenge.models.Session;
import br.com.tecchallenge.services.SessionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api")
@Api(value="API REST Sessões de Votação")
public class SessionResource {
	
	@Autowired
	SessionService sessionService;
	
	@ApiOperation(value="Retorna uma lista de sessões")
	@GetMapping("/sessions")
	public List<Session> listSessions(){
		return sessionService.listSessions();
	}
	
	@ApiOperation(value="Retorna uma sessão")
	@GetMapping("/sessions/{id}")
	public Session findSession(@PathVariable(value="id") long id){
		if (sessionService.findSession(id) == null)
			throw new ResourceNotFoundException("Sessão " + id + " não encontrada.");
		
		return sessionService.findSession(id);
	}
	
	@ApiOperation(value="Salva uma sessão")
	@PostMapping("/sessions")
	public Session saveSession(@RequestBody @Valid Session session) {
		return sessionService.saveSession(session);
	}
	
	@ApiOperation(value="Deleta uma sessão")
	@DeleteMapping("/sessions")
	public void deleteSession(@RequestBody @Valid Session session) {
		if (sessionService.findSession(session.getId()) == null)
			throw new ResourceNotFoundException("Sessão " + session.getId() + " não encontrada.");
		
		sessionService.deleteSession(session);
	}
	
	@ApiOperation(value="Altera uma sessão")
	@PutMapping("/sessions")
	public Session updateSession(@RequestBody @Valid Session session) {
		if (sessionService.findSession(session.getId()) == null)
			throw new ResourceNotFoundException("Sessão " + session.getId() + " não encontrada.");
		
		return sessionService.updateSession(session);
	}

}
