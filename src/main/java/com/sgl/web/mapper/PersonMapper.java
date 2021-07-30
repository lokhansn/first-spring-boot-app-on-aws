package com.sgl.web.mapper;

import com.sgl.domain.Person;
import com.sgl.model.PersonDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    Person personDtoToPerson(PersonDto personDto);
    PersonDto personToPersonDto(Person person);
}
