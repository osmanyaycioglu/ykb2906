package com.training.ykb.spring;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person/provision")
public class PersonProvisionRest {

    @PutMapping
    public void provision(@RequestBody final Person person) {
    }

    @DeleteMapping
    public void deactivate(@RequestParam("id") final long personId) {
    }

}
