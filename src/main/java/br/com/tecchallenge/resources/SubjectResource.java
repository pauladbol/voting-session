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
import br.com.tecchallenge.models.Subject;
import br.com.tecchallenge.services.SubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api")
@Api(value="API REST Pautas de Votação")
public class SubjectResource {
	
	@Autowired
	SubjectService subjectService;
	
	@ApiOperation(value="Retorna uma lista de pautas")
	@GetMapping("/subjects")
	public List<Subject> listSubjects(){
		return subjectService.listSubjects();
	}
	
	@ApiOperation(value="Retorna uma pauta")
	@GetMapping("/subjects/{id}")
	public Subject findSubject(@PathVariable(value="id") long id){
		if (subjectService.findSubject(id) == null)
			throw new ResourceNotFoundException("Pauta " + id + " não encontrada.");
		
		return subjectService.findSubject(id);
	}
	
	@ApiOperation(value="Salva uma pauta")
	@PostMapping("/subjects")
	public Subject saveSubject(@RequestBody @Valid Subject subject) {
		return subjectService.saveSubject(subject);
	}
	
	@ApiOperation(value="Deleta uma pauta")
	@DeleteMapping("/subjects")
	public void deleteSubject(@RequestBody @Valid Subject subject) {
		if (subjectService.findSubject(subject.getId()) == null)
			throw new ResourceNotFoundException("Pauta " + subject.getId() + " não encontrada.");
		
		subjectService.deleteSubject(subject);
	}
	
	@ApiOperation(value="Altera uma pauta")
	@PutMapping("/subjects")
	public Subject updateSubject(@RequestBody @Valid Subject subject) {
		if (subjectService.findSubject(subject.getId()) == null)
			throw new ResourceNotFoundException("Pauta " + subject.getId() + " não encontrada.");
		
		return subjectService.updateSubject(subject);
	}
	 
	@ApiOperation(value="Retorna uma pauta com o resultado dos votos calculado")
	@GetMapping("/subjects/{id}/result")
	public Subject findSubjectResult(@PathVariable(value="id") long id){
		if (subjectService.findSubject(id) == null)
			throw new ResourceNotFoundException("Pauta " + id + " não encontrada.");
		
		return subjectService.findSubjectResult(id);
	}
}
