package com.amodsachintha.feedbackapp.bootstrap;

import com.amodsachintha.feedbackapp.models.Feedback;
import com.amodsachintha.feedbackapp.models.Person;
import com.amodsachintha.feedbackapp.models.Region;
import com.amodsachintha.feedbackapp.models.Service;
import com.amodsachintha.feedbackapp.repositories.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;


@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private PersonRepository personRepository;
    private RegionRepository regionRepository;
    private ServiceRepository serviceRepository;
    private FeedbackRepository feedbackRepository;

    private Logger log = LogManager.getLogger(DataLoader.class);

    public DataLoader(PersonRepository personRepository, RegionRepository regionRepository, ServiceRepository serviceRepository, FeedbackRepository feedbackRepository) {
        this.personRepository = personRepository;
        this.regionRepository = regionRepository;
        this.serviceRepository = serviceRepository;
        this.feedbackRepository = feedbackRepository;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Service service = new Service("Taxes");
        serviceRepository.save(service);

        Region region = new Region("Southern Provice");
        regionRepository.save(region);

        Person person = new Person("Amod","Sachintha","123456","774840329","Galle",region);
        Feedback feedback1 = new Feedback("Good Stuff",service);
        Feedback feedback2 = new Feedback("Good Stuff",service);
        feedback1.setPerson(person);
        feedback2.setPerson(person);
        personRepository.save(person);

        feedbackRepository.save(feedback1);
        feedbackRepository.save(feedback2);

        Feedback feedback3 = new Feedback("MMMM",service);
        feedback3.setPerson(person);
        feedbackRepository.save(feedback3);

    }
}
