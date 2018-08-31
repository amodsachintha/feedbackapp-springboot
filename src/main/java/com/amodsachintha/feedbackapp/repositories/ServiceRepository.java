package com.amodsachintha.feedbackapp.repositories;

import com.amodsachintha.feedbackapp.models.Service;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ServiceRepository extends CrudRepository<Service,Integer> {

    Optional<Service> findById(Integer id);
}
