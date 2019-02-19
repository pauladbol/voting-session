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

import br.com.tecchallenge.models.Subject;
import br.com.tecchallenge.repositories.SubjectRepository;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api")
public class SubjectResource {
	
	@Autowired
	SubjectRepository subjectRepository;
	
	@GetMapping("/subjects")
	public List<Subject> listSubjects(){
		return subjectRepository.findAll();
	}
	
	@GetMapping("/subject/{id}")
	public Subject findSubject(@PathVariable(value="id") long id){
		return subjectRepository.findById(id);
	}
	
	@PostMapping("/subject")
	public Subject saveSubject(@RequestBody @Valid Subject subject) {
		return subjectRepository.save(subject);
	}
	
	@DeleteMapping("/subject")
	public void deleteSubject(@RequestBody @Valid Subject subject) {
		subjectRepository.delete(subject);
	}
	
	@PutMapping("/subject")
	public Subject updateSubject(@RequestBody @Valid Subject subject) {
		return subjectRepository.save(subject);
	}
	 

}
