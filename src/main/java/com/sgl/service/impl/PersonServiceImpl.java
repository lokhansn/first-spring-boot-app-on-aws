package com.sgl.service.impl;

import com.sgl.domain.Person;
import com.sgl.model.PersonDto;
import com.sgl.repository.PersonRepository;
import com.sgl.service.PersonService;
import com.sgl.web.controller.NotFoundException;
import com.sgl.web.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PersonMapper personMapper;

    @Override
    public PersonDto getPerson(int personId) {
        Optional<Person> personOptional = personRepository.findById(personId);
        return personMapper.personToPersonDto(personOptional.orElseThrow(() -> new NotFoundException()));
    }

    @Override
    public List<PersonDto> getPersons() {
        List<Person> personList = personRepository.findAll();
        return personList.stream().map(p -> personMapper.personToPersonDto(p)).collect(Collectors.toList());
    }

    @Override
    public PersonDto createPerson(PersonDto personDto) {
        Person person = personRepository.save(personMapper.personDtoToPerson(personDto));
        return personMapper.personToPersonDto(person);
    }

    @Override
    public PersonDto updatePerson(int personId, PersonDto personDto) {
        Person personInDb = personRepository.getById(personId);

        personInDb.setFirstName(personDto.getFirstName());
        personInDb.setLastName(personDto.getLastName());
        personInDb.setEmail(personDto.getEmail());
        personInDb.setAge(personDto.getAge());

        personInDb = personRepository.save(personInDb);

        return personMapper.personToPersonDto(personInDb);
    }

    @Override
    public void deletePerson(int personId) {
        personRepository.deleteById(personId);
    }
}
