package com.sgl.web.controller;

import com.sgl.model.PersonDto;
import com.sgl.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/persons")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping("/{personId}")
    public ResponseEntity<PersonDto> getPerson(@PathVariable int personId){
        PersonDto personDto = personService.getPerson(personId);
        return new ResponseEntity<>(personDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PersonDto>> getPersons(){
        List<PersonDto> personDtos = personService.getPersons();
        return new ResponseEntity<>(personDtos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PersonDto> createPerson(@RequestBody PersonDto personDto){
        PersonDto createdPersonDto = personService.createPerson(personDto);
        return new ResponseEntity<>(createdPersonDto, HttpStatus.CREATED);
    }

    @PutMapping("/{personId}")
    public ResponseEntity<PersonDto> updatePerson(@PathVariable int personId, @RequestBody PersonDto personDto){
        PersonDto updatedPersonDto = personService.updatePerson(personId, personDto);
        return new ResponseEntity<>(updatedPersonDto, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{personId}")
    public ResponseEntity<HttpStatus> deletePerson(@PathVariable int personId){
        personService.deletePerson(personId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
