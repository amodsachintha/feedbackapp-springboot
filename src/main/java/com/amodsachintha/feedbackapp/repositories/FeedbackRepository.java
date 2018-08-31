package com.amodsachintha.feedbackapp.repositories;

import com.amodsachintha.feedbackapp.models.Feedback;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface FeedbackRepository extends CrudRepository<Feedback,Long> {
    Optional<Feedback> findById(Long id);
    Optional<Feedback> findAllByPerson_Nic(String nic);
}
