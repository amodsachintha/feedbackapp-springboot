package com.amodsachintha.feedbackapp.controllers;

import com.amodsachintha.feedbackapp.services.person.PersonServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {
    private PersonServiceImpl personServiceImpl;

    public IndexController(PersonServiceImpl personServiceImpl){
        this.personServiceImpl = personServiceImpl;
    }

    @RequestMapping({"","/","/index"})
    public String index(Model model){
        model.addAttribute("persons",personServiceImpl.getPersons());
        return "index";
    }
}
