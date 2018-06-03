package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {

    /* Разновидности запросов:
     *
     * GET    - основное назначение метода, предоставление
     *          (получение) информации
     * POST   - основное назначение, создание записи либо передача
     *          новых данных на сервер
     * PUT    - основное назначение, изменение каких либо данных на
     *          сервере
     * DELETE - основное назначение, удаление данных с сервера
     *
     * */

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String indexPage() {
        return "index";
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String formPage() {
        return "form";
    }

    @RequestMapping(value = "/backForm", method = RequestMethod.GET)
    public String backendFormPage() {
        return "backend_form";
    }

}
