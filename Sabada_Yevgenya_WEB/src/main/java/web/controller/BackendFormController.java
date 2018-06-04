package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BackendFormController {
    @RequestMapping(value = "/backendform", method = RequestMethod.POST)
    public String create(
            @RequestParam("name") String name,
            @RequestParam("surname") String surname,
            @RequestParam("age") Integer  age


    ){
        System.out.println("************New Client**************");
        System.out.println("Name" + name);
        System.out.println("Surname" + surname);
        System.out.println("Age" + age);

        return "backend_form";

    }


}
