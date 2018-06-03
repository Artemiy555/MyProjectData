package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {

    /*
     * Запросы:
     *
     * GET   -   основное назначение метода, предоставление
     *           получение информации
     *
     * POST  -   основное назначение метода, создания записи
     *           либо передача данных сервер
     *
     * PUT   -   основное назначение, изменение каких либо
     *           данных на сервера
     *
     * DELETE -  основное назначение, удаление данных с сервера
     *           можно делать и POST'ом
     */

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String indexPage() { return "index"; }

    // в value выписываем url
    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String formPage() { return "form"; }

}
