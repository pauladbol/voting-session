package br.com.tecchallenge.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.tecchallenge.models.Session;
import br.com.tecchallenge.services.SessionService;

@RestController
@RequestMapping("/session/")
public class SessionController {

	@Autowired
    private SessionService sessionService;
     
	@ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{sessionId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Session get(@PathVariable(value = "sessionId") String sessionId){
        return sessionService.findById(sessionId);
    }
    
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Session> findAll(){
        return sessionService.findAll();
    }
    
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Session create(@RequestBody Session session){
        return sessionService.create(session);
    }
    
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Session update(@RequestBody Session session){
        return sessionService.update(session);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{sessionId}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "sessionId") String sessionId){
    	sessionService.delete(sessionId);
    }
}
