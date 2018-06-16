package web.controller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
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
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            method = RequestMethod.GET)
    public @ResponseBody String findAllPersons() {
//        List<Person> persons = personRepository.findAll();
//        /* JSON - формат передачи данных в виде
//        *         строковой информации */
        JSONArray body = new JSONArray();
        body.addAll(personRepository.findAll());
//        for (Person p : persons) {
//            JSONObject item = new JSONObject();
//            item.put("id", p.getId());
//            item.put("name", p.getName());
//            item.put("surname", p.getSurname());
//            item.put("age", p.getAge());
//            body.add(item);
//        }
        return body.toJSONString();
    }
}
