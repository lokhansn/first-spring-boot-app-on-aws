package com.sgl.service;

import com.sgl.model.PersonDto;

import java.util.List;

public interface PersonService {
    PersonDto getPerson(int personId);

    List<PersonDto> getPersons();

    PersonDto createPerson(PersonDto personDto);

    PersonDto updatePerson(int personId, PersonDto personDto);

    void deletePerson(int personId);
}
