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
import br.com.tecchallenge.services.SubjectService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api")
public class SubjectResource {
	
	@Autowired
	SubjectService subjectService;
	
	@GetMapping("/subjects")
	public List<Subject> listSubjects(){
		return subjectService.listSubjects();
	}
	
	@GetMapping("/subject/{id}")
	public Subject findSubject(@PathVariable(value="id") long id){
		return subjectService.findSubject(id);
	}
	
	@PostMapping("/subject")
	public Subject saveSubject(@RequestBody @Valid Subject subject) {
		return subjectService.saveSubject(subject);
	}
	
	@DeleteMapping("/subject")
	public void deleteSubject(@RequestBody @Valid Subject subject) {
		subjectService.deleteSubject(subject);
	}
	
	@PutMapping("/subject")
	public Subject updateSubject(@RequestBody @Valid Subject subject) {
		return subjectService.updateSubject(subject);
	}
	 

}
