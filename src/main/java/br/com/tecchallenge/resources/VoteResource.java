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

import br.com.tecchallenge.models.Vote;
import br.com.tecchallenge.services.VoteService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api")
public class VoteResource {
	
	@Autowired
	VoteService voteService;
	
	@GetMapping("/votes")
	public List<Vote> listVotes(){
		return voteService.listVotes();
	}
	
	@GetMapping("/vote/{id}")
	public Vote findVote(@PathVariable(value="id") long id){
		return voteService.findVote(id);
	}
	
	@PostMapping("/vote")
	public Vote saveVote(@RequestBody @Valid Vote vote) {
			return voteService.saveVote(vote);		
	}
	
	@DeleteMapping("/vote")
	public void deleteVote(@RequestBody @Valid Vote vote) {
		voteService.deleteVote(vote);
	}
	
	@PutMapping("/vote")
	public Vote updateVote(@RequestBody @Valid Vote vote) {
		return voteService.updateVote(vote);
	}
	 

}
