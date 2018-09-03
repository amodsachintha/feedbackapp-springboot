package com.amodsachintha.feedbackapp.bootstrap;

import com.amodsachintha.feedbackapp.models.Feedback;
import com.amodsachintha.feedbackapp.models.Person;
import com.amodsachintha.feedbackapp.models.Region;
import com.amodsachintha.feedbackapp.models.Service;
import com.amodsachintha.feedbackapp.repositories.FeedbackRepository;
import com.amodsachintha.feedbackapp.repositories.PersonRepository;
import com.amodsachintha.feedbackapp.repositories.RegionRepository;
import com.amodsachintha.feedbackapp.repositories.ServiceRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;



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

        Region western = new Region("Western");
        regionRepository.save(western);
        Person person1 = new Person("Niran","Peiris","456789","075112354","Piliyandala",western);
        Feedback feedback4 = new Feedback("Too Late",service);
        feedback4.setPerson(person1);
        personRepository.save(person1);
        feedbackRepository.save(feedback4);

    }
}
