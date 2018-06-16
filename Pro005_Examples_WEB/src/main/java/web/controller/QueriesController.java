package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import web.dao.PersonRepository;
import web.domain.Person;

@Controller
public class QueriesController {

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping(
            value = "/person/create",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED) //http_code 201 - Успешное создание записи на бекэнде
    public void createPerson(
            @RequestParam("name") String name,
            @RequestParam("surname") String surname,
            @RequestParam("age") Integer age) {
        personRepository.saveAndFlush(new Person(name, surname, age));
    }
}
