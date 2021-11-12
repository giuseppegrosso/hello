package it.plansoft.hello.controller;

import it.plansoft.hello.dto.RubricaDto;
import org.springframework.web.bind.annotation.*;

/**
 * @author Giuseppe Grosso
 * @project hello
 * @since 10/11/2021
 */

//
// http://127.0.0.1:8080/hello/sayHello/Giuseppe GET --> pathVariable
// http://127.0.0.1:8080/hello/sayHello?name=Giuseppe GET --> RequestParam
//  POST
// http://127.0.0.1:8080/hello/sayHello
//    payload
// {
//  "name"="Giuseppe",
//  "surname":"Grosso",
//  "address":"via xxx"
//  }

//  PUT
// http://127.0.0.1:8080/hello/sayHello/10 (pathvariable)
//    payload
// {
//  "name"="Giuseppe",
//  "surname":"Grosso",
//  "address":"via yyyyy"
//  }

//  DELETE
// http://127.0.0.1:8080/hello/sayHello/10 (pathvariable)

@RestController
@RequestMapping("/hello")
public class HelloController {

    // usata quando recupero un oggetto che so che esiste
    @GetMapping("/sayHello/{name}")
    public String sayMyNamePAth(@PathVariable String name) {
        // no logica ma si recupera tramite un oggetto service.

        return "hello to " + name;
    }

    // usata per effettuare delle ricerche
    @GetMapping("/sayHello")
    public String sayHelloRequest(@RequestParam String name, @RequestParam String cognome, @RequestParam String indirizzo) {
        return "hello to " + name + " " + cognome + " " + indirizzo;
    }

    // usata per effettuare delle ricerche
    @PostMapping("/sayHello")
    public String sayHelloPost(@RequestBody RubricaDto rubricaDto) {
        return "hello to " + rubricaDto.getName() + " " + rubricaDto.getSurname() + " " + rubricaDto.getAddress();
    }

    // usata per effettuare delle ricerche
    @PostMapping("/saythanx")
    public String sayHelloThanx(@RequestBody RubricaDto rubricaDto) {
        return "thanx to " + rubricaDto.getName() + " " + rubricaDto.getSurname() + " " + rubricaDto.getAddress();
    }

//    {
//        "name": "giuseppe",
//        "surname": "grosso",
//        "address": "via xxx"
//     }

//    <name>giuseppe</name>
//    <surname>grosso</surname>

}
