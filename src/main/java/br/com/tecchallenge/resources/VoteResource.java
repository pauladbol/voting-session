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
import br.com.tecchallenge.repositories.VoteRepository;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api")
public class VoteResource {
	
	@Autowired
	VoteRepository voteRepository;
	
	@GetMapping("/votes")
	public List<Vote> listVotes(){
		return voteRepository.findAll();
	}
	
	@GetMapping("/vote/{id}")
	public Vote findVote(@PathVariable(value="id") long id){
		return voteRepository.findById(id);
	}
	
	@PostMapping("/vote")
	public Vote saveVote(@RequestBody @Valid Vote vote) {
		return voteRepository.save(vote);
	}
	
	@DeleteMapping("/vote")
	public void deleteVote(@RequestBody @Valid Vote vote) {
		voteRepository.delete(vote);
	}
	
	@PutMapping("/vote")
	public Vote updateVote(@RequestBody @Valid Vote vote) {
		return voteRepository.save(vote);
	}
	 

}
