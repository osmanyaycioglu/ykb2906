package com.training.ykb.spring;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/first")
public class MyFirstRest {


    @GetMapping("/hello")
    public String hello() {
        return "Hello world";
    }

    @GetMapping("/hello2/{xyz}/{abc}")
    public String hello2(@PathVariable("xyz") final String name,
                         @PathVariable("abc") final String surname) {
        return "Hello world " + name + " " + surname;
    }

    @GetMapping("/hello3/name/{xyz}/surname/{abc}")
    public String hello3(@PathVariable("xyz") final String name,
                         @PathVariable("abc") final String surname) {
        return "Hello world " + name + " " + surname;
    }

    @GetMapping("/hello4")
    public String hello4(@RequestParam("xyz") final String name,
                         @RequestParam("abc") final String surname) {
        return "Hello world " + name + " " + surname;
    }

    @GetMapping("/hello5")
    public String hello5(@RequestParam("xyz") final String name,
                         @RequestParam("abc") final String surname,
                         final HttpServletRequest request) {
        String headerLoc = request.getHeader("abc");
        return "Hello world " + name + " " + surname;
    }

    @GetMapping("/hello7/{uvf}")
    public String hello7(@RequestHeader("xyz") final String name,
                         @RequestHeader("abc") final String surname,
                         @PathVariable("uvf") final int age) {
        return "Hello world " + name + " " + surname + " " + age;
    }

    @PostMapping("/hello8")
    public String hello8(@RequestBody final Person person) {
        return "Hello world " + person.getName() + " " + person.getSurname() + " birthdate : " + person.getBirthdate();
    }

    @PostMapping(value = "/hello9",
                 consumes = {
                              MediaType.APPLICATION_JSON_VALUE,
                              MediaType.APPLICATION_XML_VALUE
                 },
                 produces = {
                              MediaType.APPLICATION_JSON_VALUE,
                              MediaType.APPLICATION_XML_VALUE
                 })
    public Person hello9(@RequestBody final Person person) {
        person.setName("mehmet");
        return person;
    }

    @PostMapping("/hello10")
    public Person hello10(@Validated @RequestBody final Person person) {
        if (person.getSurname() == null) {
            throw new IllegalArgumentException("name null olamaz");
        }
        return person;
    }


}

