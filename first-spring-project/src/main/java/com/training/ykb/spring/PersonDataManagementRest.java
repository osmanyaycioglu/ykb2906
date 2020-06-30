package com.training.ykb.spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person/management")
public class PersonDataManagementRest {

    @PatchMapping
    public void update(@RequestBody final Person person) {
    }

    @GetMapping
    public void get(@RequestParam("id") final long personId) {
    }

}
