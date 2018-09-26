package web.controller;

import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import web.dao.PersonRepository;
import web.domain.Person;

import javax.annotation.PostConstruct;
import java.util.List;


@Controller
public class QueriesController {

    private Logger log;

    @Autowired
    private PersonRepository personRepository;

    @PostConstruct
    private void initialize(){
        log = LoggerFactory.getLogger(QueriesController.class);
        log.info("логер успешно создан");

    }

    @RequestMapping(
            value = "/person/create",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED) //http_code 201 - Успешное создание записи на бекэнде
    public void createPerson(
            @RequestParam("name") String name,
            @RequestParam("surname") String surname,
            @RequestParam("age") Integer age) {
        log.info("Подготовка к записи бд");
        log.info("Person:\nname : "+ name +" \nsurname : "+ surname +" \nage :"+ age);
        Person person = personRepository.saveAndFlush(new Person(name, surname, age));
        log.info("Создано" + person);
    }

    @RequestMapping(
            value = "/person/findall",
            method = RequestMethod.GET)
    public @ResponseBody String findAllPersons() {
        List<Person> persons = personRepository.findAll();
        System.out.println(persons);

        JSONArray body = new JSONArray(persons);

        return body.toString();
    }
}
