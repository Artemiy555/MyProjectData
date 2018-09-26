package web.controller;

import org.hibernate.HibernateException;
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

@Controller
public class QueriesController {

    private Logger log;

    @Autowired
    private PersonRepository personRepository;

    @PostConstruct
    private void initialize() {
        log = LoggerFactory.getLogger(QueriesController.class);
        log.info("Логгер успешно создан...");
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
        try {
            log.info("Подготовка к созданию записи");
            log.info("Person - name : " + name + " surname :" + surname + " age : " + age);
            Person person = personRepository.saveAndFlush(new Person(name, surname, age));
            log.info("Запись успешно создана: " + person);
        } catch (HibernateException exc) {
            log.error(exc.getLocalizedMessage());
            exc.printStackTrace();
        }
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
