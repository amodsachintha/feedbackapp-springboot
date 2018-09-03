package com.amodsachintha.feedbackapp.services.person;

import com.amodsachintha.feedbackapp.models.Person;
import com.amodsachintha.feedbackapp.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Set<Person> getPersons() {
        Set<Person> personSet = new HashSet<>();
        personRepository.findAll().iterator().forEachRemaining(personSet::add);
        return personSet;
    }


}
