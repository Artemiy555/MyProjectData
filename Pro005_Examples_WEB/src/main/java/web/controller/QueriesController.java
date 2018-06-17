package web.controller;


import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import web.dao.PersonRepository;
import web.domain.Person;

import java.util.List;

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

    @RequestMapping(
            value = "/person/findall",
            method = RequestMethod.GET)
    public @ResponseBody String findAllPersons() {
        JSONArray body =
                new JSONArray(personRepository.findAll());
        return body.toString();
    }
}
