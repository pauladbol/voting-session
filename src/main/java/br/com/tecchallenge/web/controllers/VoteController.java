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

import br.com.tecchallenge.models.Vote;
import br.com.tecchallenge.services.VoteService;

@RestController
@RequestMapping("/vote/")
public class VoteController {
	@Autowired
    private VoteService voteService;
     
	@ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{voteId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Vote get(@PathVariable(value = "voteId") String voteId){
        return voteService.findById(voteId);
    }
    
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Vote> findAll(){
        return voteService.findAll();
    }
    
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Vote create(@RequestBody Vote vote){
        return voteService.create(vote);
    }
    
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Vote update(@RequestBody Vote vote){
        return voteService.update(vote);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{voteId}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "voteId") String voteId){
    	voteService.delete(voteId);
    }
}
