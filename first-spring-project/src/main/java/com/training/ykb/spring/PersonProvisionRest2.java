package com.training.ykb.spring;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person/v1")
public class PersonProvisionRest2 {

    private final Map<String, Person> personMap = new HashMap<>();

    @PostMapping("/provision")
    public void provision(@RequestBody final Person person) {
        this.personMap.put(person.getName(),
                           person);
    }

    @GetMapping("/deactivate")
    public void deactivate(@RequestParam("id") final String personName) {
        this.personMap.remove(personName);
    }

    @PostMapping("/update")
    public void update(@RequestBody final Person person) {
        this.personMap.put(person.getName(),
                           person);

    }

    @GetMapping("/get")
    public Person get(@RequestParam("id") final String personId) {
        return this.personMap.get(personId);
    }


}
