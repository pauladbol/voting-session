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

import br.com.tecchallenge.models.Subject;
import br.com.tecchallenge.services.SubjectService;

@RestController
@RequestMapping("/subject/")
public class SubjectController {
	
	@Autowired
    private SubjectService subjectService;
     
	@ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{subjectId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Subject get(@PathVariable(value = "subjectId") String subjectId){
        return subjectService.findById(subjectId);
    }
    
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Subject> findAll(){
        return subjectService.findAll();
    }
    
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Subject create(@RequestBody Subject subject){
        return subjectService.create(subject);
    }
    
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Subject update(@RequestBody Subject subject){
        return subjectService.update(subject);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{subjectId}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "subjectId") String subjectId){
    	subjectService.delete(subjectId);
    }

}


