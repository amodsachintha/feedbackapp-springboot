package com.amodsachintha.feedbackapp.repositories;

import com.amodsachintha.feedbackapp.models.Region;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegionRepository extends CrudRepository<Region,Integer> {

    Optional<Region> findById(Integer id);
}
