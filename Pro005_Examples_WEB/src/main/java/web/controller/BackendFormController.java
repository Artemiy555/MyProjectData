package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.PersonRepository;
import web.domain.Person;

@Controller
public class BackendFormController {

    @Autowired
    private PersonRepository repository;

    @RequestMapping(value = "/backendform", method = RequestMethod.POST)
    public String create(
            @RequestParam("name") String name,
            @RequestParam("surname") String surname,
            @RequestParam("age") Integer age
    ) {
        System.out.println("********** New Client **********");
        System.out.println("Name: " + name);
        System.out.println("Surname: " + surname);
        System.out.println("Age: " + age);

        repository.saveAndFlush(new Person(name, surname, age));

        return "backend_form";
    }
}
