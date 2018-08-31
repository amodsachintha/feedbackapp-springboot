package com.amodsachintha.feedbackapp.repositories;

import com.amodsachintha.feedbackapp.models.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends CrudRepository<Person,Long> {

    Optional<Person> findById(Long id);

}
